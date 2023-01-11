package com.guciowons.footballguesser.footballers.league;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getLeagues(){
        return leagueRepository.findAll();
    }

    public Optional<League> getLeagueById(Integer leagueId){
        return leagueRepository.findById(leagueId);
    }
}
