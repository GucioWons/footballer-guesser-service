package com.guciowons.footballguesser.Users.Score;

import java.time.LocalDateTime;

public class ScoreResponse {
    private Integer points;
    private LocalDateTime dateTime;
    private Integer userId;

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
