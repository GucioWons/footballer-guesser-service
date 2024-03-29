package com.guciowons.footballguesser.footballers.club;

import com.guciowons.footballguesser.footballers.league.League;

import javax.persistence.*;

@Entity
@Table(name="club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer externalId;
    private String name;
    private String shortcut;
    @ManyToOne
    private League league;
    private String url;

    public Club(Integer externalId, String name, String shortcut, League league, String url) {
        this.externalId = externalId;
        this.name = name;
        this.shortcut = shortcut;
        this.league = league;
        this.url = url;
    }

    public Club() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
