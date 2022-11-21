package com.guciowons.footballguesser.Footballers.League;

import com.guciowons.footballguesser.Footballers.External.CompetitionConverter;
import com.guciowons.footballguesser.Footballers.External.Teams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;
    private final CompetitionConverter competitionConverter;

    public LeagueService(LeagueRepository leagueRepository, CompetitionConverter competitionConverter) {
        this.leagueRepository = leagueRepository;
        this.competitionConverter = competitionConverter;
    }

    public League createLeague(Teams.Competition competition){
        return leagueRepository.save(competitionConverter.convertCompetitionToLeague(competition));
    }

    public List<League> getLeagues(){
        return leagueRepository.findAll();
    }

    public Optional<League> getLeagueById(Integer leagueId){
        return leagueRepository.findById(leagueId);
    }
}
