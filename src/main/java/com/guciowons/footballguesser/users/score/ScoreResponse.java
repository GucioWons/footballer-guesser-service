package com.guciowons.footballguesser.users.score;

import java.time.LocalDateTime;

public class ScoreResponse {
    private final Integer points;
    private final LocalDateTime dateTime;
    private final Integer userId;

    public ScoreResponse(Integer points, LocalDateTime dateTime, Integer userId) {
        this.points = points;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public Integer getPoints() {
        return points;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Integer getUserId() {
        return userId;
    }
}
