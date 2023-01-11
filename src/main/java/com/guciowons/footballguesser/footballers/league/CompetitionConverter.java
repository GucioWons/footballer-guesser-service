package com.guciowons.footballguesser.footballers.league;

import com.guciowons.footballguesser.footballers.external.Teams;
import org.springframework.stereotype.Component;

@Component
public class CompetitionConverter {
    private final LeagueRepository leagueRepository;

    public CompetitionConverter(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League createLeague(Teams.Competition competition){
        return leagueRepository.save(leagueRepository.findByExternalId(competition.getId()).map(
                        league -> updateLeague(league, competition))
                .orElse(convertCompetitionToLeague(competition)));
    }

    public League convertCompetitionToLeague(Teams.Competition competition){
        return new League(competition.getId(), competition.getName(), competition.getEmblem());
    }

    public League updateLeague(League league, Teams.Competition competition) {
        League updatedLeague = new League(competition.getId(), competition.getName(), competition.getEmblem());
        updatedLeague.setId(league.getId());
        return updatedLeague;
    }
}
