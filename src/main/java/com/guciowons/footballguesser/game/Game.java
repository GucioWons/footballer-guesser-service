package com.guciowons.footballguesser.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guciowons.footballguesser.footballers.footballer.Footballer;
import com.guciowons.footballguesser.footballers.league.League;
import com.guciowons.footballguesser.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  ="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    private User player;
    @ManyToOne
    private League league;
    @ManyToOne
    private Footballer answer;
    @OneToMany(mappedBy = "game")
    private List<Guess> guesses;
    private boolean finished;

    public Game(User player, League league, Footballer answer, List<Guess> guesses, boolean finished) {
        this.player = player;
        this.league = league;
        this.answer = answer;
        this.guesses = guesses;
        this.finished = finished;
    }

    public Game() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Footballer getAnswer() {
        return answer;
    }

    public void setAnswer(Footballer answer) {
        this.answer = answer;
    }

    public List<Guess> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Guess> guesses) {
        this.guesses = guesses;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}


