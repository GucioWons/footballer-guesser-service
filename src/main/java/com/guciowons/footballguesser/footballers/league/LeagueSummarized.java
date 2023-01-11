package com.guciowons.footballguesser.footballers.league;

import com.guciowons.footballguesser.footballers.club.ClubSummarized;

import java.util.List;

public class LeagueSummarized {
    private final List<ClubSummarized> clubs;

    public LeagueSummarized(List<ClubSummarized> clubs) {
        this.clubs = clubs;
    }

    public List<ClubSummarized> getClubs() {
        return clubs;
    }
}
