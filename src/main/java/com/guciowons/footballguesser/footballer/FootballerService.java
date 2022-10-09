package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.feign.ExternalSquadClient;
import com.guciowons.footballguesser.feign.ExternalSquadToFootballersConverter;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Footballer> getFotballers() {
        return externalSquadToFootballersConverter
                .convertExternalSquadToFootballers(externalSquadClient.getExternalSquad("5740d267c15143f5b1ab75b03ffce4a3", 65));
    }

    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.getFootballersByClub(clubId);
    }

    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballerRepository.getFootballersByLeague(leagueId);
    }
}
