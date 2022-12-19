package com.guciowons.footballguesser.Footballers.Club;

import com.guciowons.footballguesser.Footballers.External.Teams;
import com.guciowons.footballguesser.Footballers.League.League;
import org.springframework.stereotype.Service;

@Service
public class ClubService {
    private final ClubRepository clubRepository;
    private final TeamConverter teamConverter;

    public ClubService(ClubRepository clubRepository, TeamConverter teamConverter) {
        this.clubRepository = clubRepository;
        this.teamConverter = teamConverter;
    }


}
