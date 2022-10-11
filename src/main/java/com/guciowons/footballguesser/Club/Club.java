package com.guciowons.footballguesser.Club;

import javax.persistence.*;

@Entity
@Table(name="club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer externalId;
    private String name;
    private String shortcut;
    private Integer leagueId;

    public Club(Integer externalId, String name, String shortcut, Integer leagueId) {
        this.externalId = externalId;
        this.name = name;
        this.shortcut = shortcut;
        this.leagueId = leagueId;
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

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeague(Integer leagueId) {
        this.leagueId = leagueId;
    }
}
