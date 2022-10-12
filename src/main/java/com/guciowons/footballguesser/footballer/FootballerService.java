package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.Club.ClubService;
import com.guciowons.footballguesser.External.*;
import com.guciowons.footballguesser.League.League;
import com.guciowons.footballguesser.League.LeagueService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final ClubService clubService;
    private final LeagueService leagueService;
    private final SquadClient squadClient;
    private final SquadConverter squadConverter;

    public FootballerService(FootballerRepository footballerRepository, ClubService clubService, LeagueService leagueService, SquadClient squadClient, SquadConverter squadConverter) {
        this.footballerRepository = footballerRepository;
        this.clubService = clubService;
        this.leagueService = leagueService;
        this.squadClient = squadClient;
        this.squadConverter = squadConverter;
    }


    public List<Footballer> getFootballers(){
        AtomicInteger counter = new AtomicInteger(0);
        Arrays.asList("BL1", "PL").forEach(leagueCode ->{
            Teams teams = getTeamsFromLeague(counter, leagueCode);
            League league = leagueService.createLeague(teams.getCompetition());
            teams.getTeams().forEach(team -> getPlayersAndSave(counter, team, league));
        });
        return footballerRepository.findAll();
    }

    private Teams getTeamsFromLeague(AtomicInteger counter, String leagueCode){
        checkCounter(counter);
        return squadClient.getTeams("5740d267c15143f5b1ab75b03ffce4a3", leagueCode);
    }

    private void getPlayersAndSave(AtomicInteger counter, Teams.Team team, League league){
        checkCounter(counter);
        footballerRepository.saveAll(getPlayersFromTeam(team, league));
    }

    private List<Footballer> getPlayersFromTeam(Teams.Team team, League league) {
        return squadConverter.convertSquadToFootballers(
                squadClient.getSquad("5740d267c15143f5b1ab75b03ffce4a3", team.getId()),
                clubService.createClub(team, league));
    }

    private void checkCounter(AtomicInteger counter) {
        System.out.println(counter.get());
        if (counter.get() % 10 == 0 && counter.get() != 0) {
            try {
                TimeUnit.MINUTES.sleep(1);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        counter.incrementAndGet();
    }

    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.findAllByClubId(clubId);
    }

    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballerRepository.findAllByClubLeagueId(leagueId);
    }
}
