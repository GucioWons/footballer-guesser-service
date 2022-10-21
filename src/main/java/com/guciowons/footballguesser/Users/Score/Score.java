package com.guciowons.footballguesser.Users.Score;

import com.guciowons.footballguesser.League.League;
import com.guciowons.footballguesser.Users.User;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"user_id", "league_id"})}, name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private League league;
    private Long points;

    public Score(User user, League league, Long points) {
        this.user = user;
        this.league = league;
        this.points = points;
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

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
