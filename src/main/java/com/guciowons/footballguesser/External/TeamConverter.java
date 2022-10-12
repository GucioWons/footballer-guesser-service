package com.guciowons.footballguesser.External;

import com.guciowons.footballguesser.Club.Club;
import com.guciowons.footballguesser.League.League;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {
    public Club convertTeamToClub(Teams.Team team, League league) {
        return new Club(team.getId(), team.getName(), team.getTla(), league);
    }
}
