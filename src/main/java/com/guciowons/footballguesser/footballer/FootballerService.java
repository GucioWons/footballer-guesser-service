package com.guciowons.footballguesser.footballer;

import com.fasterxml.jackson.databind.JsonNode;
import com.guciowons.footballguesser.feign.ExternalSquad;
import com.guciowons.footballguesser.feign.ExternalSquadClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final ExternalSquadClient externalSquadClient;

    public FootballerService(FootballerRepository footballerRepository, ExternalSquadClient externalSquadClient) {
        this.footballerRepository = footballerRepository;
        this.externalSquadClient = externalSquadClient;
    }

    public ExternalSquad getFotballers() {
        return externalSquadClient.getExternalSquad("af92d87103df3ed550594a8516ec3729", 33);
    }

    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.getFootballersByClub(clubId);
    }

    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballerRepository.getFootballersByLeague(leagueId);
    }
}
