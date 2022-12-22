package com.guciowons.footballguesser.Footballers.League;

import com.guciowons.footballguesser.Footballers.Club.ClubSummarized;

import java.util.List;

public class LeagueSummarized {
    private List<ClubSummarized> clubs;

    public LeagueSummarized(List<ClubSummarized> clubs) {
        this.clubs = clubs;
    }

    public List<ClubSummarized> getClubs() {
        return clubs;
    }

    public void setClubs(List<ClubSummarized> clubs) {
        this.clubs = clubs;
    }
}
