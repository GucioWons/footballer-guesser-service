package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.Club.ClubService;
import com.guciowons.footballguesser.External.SquadClient;
import com.guciowons.footballguesser.External.SquadConverter;
import com.guciowons.footballguesser.External.Teams;
import com.guciowons.footballguesser.League.League;
import com.guciowons.footballguesser.League.LeagueService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class FootballerProvider {
    private final FootballerRepository footballerRepository;
    private final LeagueService leagueService;
    private final ClubService clubService;
    private final SquadClient squadClient;
    private final SquadConverter squadConverter;

    public FootballerProvider(FootballerRepository footballerRepository, LeagueService leagueService, ClubService clubService, SquadClient squadClient, SquadConverter squadConverter) {
        this.footballerRepository = footballerRepository;
        this.leagueService = leagueService;
        this.clubService = clubService;
        this.squadClient = squadClient;
        this.squadConverter = squadConverter;
    }

    public void getFootballers(List<String> leagues){
        AtomicInteger counter = new AtomicInteger(0);
        leagues.forEach(leagueCode ->{
            Teams teams = getTeamsFromLeague(counter, leagueCode);
            League league = leagueService.createLeague(teams.getCompetition());
            teams.getTeams().forEach(team -> getPlayersAndSave(counter, team, league));
        });
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
}
