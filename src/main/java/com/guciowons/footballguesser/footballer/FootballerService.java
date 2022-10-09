package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.feign.ExternalSquadClient;
import com.guciowons.footballguesser.feign.ExternalSquadToFootballersConverter;
import com.guciowons.footballguesser.feign.ExternalTeams;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final ExternalSquadClient externalSquadClient;

    private final ExternalSquadToFootballersConverter externalSquadToFootballersConverter;

    public FootballerService(FootballerRepository footballerRepository, ExternalSquadClient externalSquadClient, ExternalSquadToFootballersConverter externalSquadToFootballersConverter) {
        this.footballerRepository = footballerRepository;
        this.externalSquadClient = externalSquadClient;
        this.externalSquadToFootballersConverter = externalSquadToFootballersConverter;
    }

    public List<Footballer> getFootballers(){
        List<String> leagues = Arrays.asList("BL1", "PL");
        List<Footballer> footballers = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);
        leagues.forEach(league -> {
            try {
                checkCounter(counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ExternalTeams externalTeams = getTeamsFromLeague(league);
            externalTeams.getTeams().forEach(externalTeam -> {
                try {
                    checkCounter(counter);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                footballers.addAll(getPlayersFromTeam(externalTeam, externalTeams));
            });
        });
        return footballers;
    }

    private void checkCounter(AtomicInteger counter) throws InterruptedException {
        System.out.println(counter.get());
        if (counter.get() % 10 == 0 && counter.get() != 0) {
            System.out.println("Pauza");
            TimeUnit.MINUTES.sleep(1);
        }
        counter.incrementAndGet();
    }

    private ExternalTeams getTeamsFromLeague(String league) {
        return externalSquadClient.getExternalTeams("5740d267c15143f5b1ab75b03ffce4a3", league);
    }

    private List<Footballer> getPlayersFromTeam(ExternalTeams.ExternalTeam externalTeam, ExternalTeams externalTeams) {
        return externalSquadToFootballersConverter.convertExternalSquadToFootballers(externalSquadClient.getExternalSquad(
                "5740d267c15143f5b1ab75b03ffce4a3", externalTeam.getId()), externalTeam, externalTeams.getCompetition());
    }







    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.getFootballersByClub(clubId);
    }

    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballerRepository.getFootballersByLeague(leagueId);
    }
}
