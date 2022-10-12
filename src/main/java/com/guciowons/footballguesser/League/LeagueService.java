package com.guciowons.footballguesser.League;

import com.guciowons.footballguesser.External.CompetitionConverter;
import com.guciowons.footballguesser.External.Teams;
import org.springframework.stereotype.Service;

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
}
