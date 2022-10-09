package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.feign.ExternalSquadClient;
import com.guciowons.footballguesser.feign.ExternalSquadToFootballersConverter;
import com.guciowons.footballguesser.feign.ExternalTeams;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public List<Footballer> getFotballers() throws InterruptedException {
        List<String> leagues = Arrays.asList("BL1", "PL");
        List<Footballer> footballers = new ArrayList<>();
        int i =0;
        for(String league : leagues){
            if(i == 10){
                i=0;
                TimeUnit.MINUTES.sleep(1);
            }
            ExternalTeams externalTeams = externalSquadClient.getExternalTeams("5740d267c15143f5b1ab75b03ffce4a3", league);
            i++;
            for(ExternalTeams.ExternalTeam externalTeam : externalTeams.getTeams()){
                if(i == 10){
                    i=0;
                    TimeUnit.MINUTES.sleep(1);
                }
                footballers.addAll(externalSquadToFootballersConverter.convertExternalSquadToFootballers(
                        externalSquadClient.getExternalSquad("5740d267c15143f5b1ab75b03ffce4a3",
                                externalTeam.getId()), externalTeam, externalTeams.getCompetition()));
                i++;
            }
        }
        return footballers;
    }

    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.getFootballersByClub(clubId);
    }

    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballerRepository.getFootballersByLeague(leagueId);
    }
}
