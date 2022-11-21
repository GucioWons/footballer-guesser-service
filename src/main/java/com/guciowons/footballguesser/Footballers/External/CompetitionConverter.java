package com.guciowons.footballguesser.Footballers.External;

import com.guciowons.footballguesser.Footballers.League.League;
import org.springframework.stereotype.Component;

@Component
public class CompetitionConverter {
    public League convertCompetitionToLeague(Teams.Competition competition){
        return new League(competition.getId(), competition.getName(), competition.getEmblem());
    }
}
