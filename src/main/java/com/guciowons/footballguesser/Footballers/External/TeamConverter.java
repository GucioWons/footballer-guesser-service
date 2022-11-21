package com.guciowons.footballguesser.Footballers.External;

import com.guciowons.footballguesser.Footballers.Club.Club;
import com.guciowons.footballguesser.Footballers.League.League;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {
    public Club convertTeamToClub(Teams.Team team, League league) {
        return new Club(team.getId(), team.getName(), team.getTla(), league, team.getCrest());
    }
}
