package com.guciowons.footballguesser.External;

import com.guciowons.footballguesser.League.League;
import org.springframework.stereotype.Component;

@Component
public class CompetitionConverter {
    public League convertCompetitionToLeague(Teams.Competition competition){
        return new League(competition.getId(), competition.getName());
    }
}
