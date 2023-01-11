package com.guciowons.footballguesser.footballers.club;

import com.guciowons.footballguesser.footballers.external.Teams;
import com.guciowons.footballguesser.footballers.league.League;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {
    private final ClubRepository clubRepository;

    public TeamConverter(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club createClub(Teams.Team team, League league){
        return clubRepository.save(clubRepository.findByExternalId(team.getId()).map(
                        club -> updateClub(club, team, league))
                .orElse(convertTeamToClub(team, league)));
    }

    public Club convertTeamToClub(Teams.Team team, League league) {
        return new Club(team.getId(), team.getName(), team.getTla(), league, team.getCrest());
    }

    public Club updateClub(Club club, Teams.Team team, League league){
        Club updatedClub = new Club(team.getId(), team.getName(), team.getTla(), league, team.getCrest());
        updatedClub.setId(club.getId());
        return updatedClub;
    }
}
