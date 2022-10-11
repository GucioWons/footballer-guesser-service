package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.entity.Club;

public class Footballer {
    private Integer id;
    private String name;
    private String nationality;
    private Club club;
    private Integer number;
    private Position position;

    public Footballer(Integer id, String name, String nationality, Club club, Integer number, Position position) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.club = club;
        this.number = number;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
