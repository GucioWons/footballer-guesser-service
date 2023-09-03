package com.guciowons.footballguesser.score;

public class ScoreSummarized {
    private final String username;
    private Integer score;

    public ScoreSummarized(String username, Integer score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
