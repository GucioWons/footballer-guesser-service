package com.guciowons.footballguesser.game;

import com.guciowons.footballguesser.footballers.footballer.Footballer;

import javax.persistence.*;

@Entity
@Table(name = "guess")
public class Guess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Footballer footballer;
    @ManyToOne
    private Game game;
    private boolean nationality;
    private boolean league;
    private boolean club;
    private boolean number;
    private boolean position;


    public Guess(Footballer footballer, boolean nationality, boolean league, boolean club, boolean number, boolean position) {
        this.footballer = footballer;
        this.nationality = nationality;
        this.league = league;
        this.club = club;
        this.number = number;
        this.position = position;
    }

    public Guess() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Footballer getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballer footballer) {
        this.footballer = footballer;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isNationality() {
        return nationality;
    }

    public void setNationality(boolean nationality) {
        this.nationality = nationality;
    }

    public boolean isLeague() {
        return league;
    }

    public void setLeague(boolean league) {
        this.league = league;
    }

    public boolean isClub() {
        return club;
    }

    public void setClub(boolean club) {
        this.club = club;
    }

    public boolean isNumber() {
        return number;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }
}
