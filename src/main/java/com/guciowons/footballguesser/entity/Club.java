package com.guciowons.footballguesser.entity;

public class Club {
    private final Integer id;
    private String name;
    private String shortcut;
    private League league;

    public Club(Integer id, String name, String shortcut, League league) {
        this.id = id;
        this.name = name;
        this.shortcut = shortcut;
        this.league = league;
    }

    public Integer getId() {
        return id;
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
}
