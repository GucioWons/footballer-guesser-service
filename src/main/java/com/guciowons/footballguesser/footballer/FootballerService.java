package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.footballer.Footballer;
import com.guciowons.footballguesser.footballer.FootballerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;

    public FootballerService(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    public List<Footballer> getFotballers() {
        return footballerRepository.getFootballers();
    }

    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.getFootballersByClub(clubId);
    }

    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballerRepository.getFootballersByLeague(leagueId);
    }
}
