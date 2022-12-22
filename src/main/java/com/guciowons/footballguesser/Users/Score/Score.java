package com.guciowons.footballguesser.Users.Score;

import com.guciowons.footballguesser.Footballers.League.League;
import com.guciowons.footballguesser.Users.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private League league;
    private Integer points;
    private LocalDateTime dateTime;

    public Score(User user, League league, Integer points, LocalDateTime dateTime) {
        this.user = user;
        this.league = league;
        this.points = points;
        this.dateTime = dateTime;
    }

    public Score() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
