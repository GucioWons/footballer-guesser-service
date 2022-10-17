package com.guciowons.footballguesser.footballer;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final FootballerProvider footballerProvider;

    public FootballerService(FootballerRepository footballerRepository, FootballerProvider footballerProvider) {
        this.footballerRepository = footballerRepository;
        this.footballerProvider = footballerProvider;
    }

    @PostConstruct
    public void getFootballersFromExternalApi(){
        footballerProvider.getFootballers(Arrays.asList("BL1", "PL"));
    }

    public List<Footballer> getFootballers(){
        return footballerRepository.findAll();
    }

    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.findAllByClubId(clubId);
    }

    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballerRepository.findAllByClubLeagueId(leagueId);
    }
}
