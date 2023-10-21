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


    public Guess(Footballer footballer, Game game) {
        this.footballer = footballer;
        this.game = game;
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
}
