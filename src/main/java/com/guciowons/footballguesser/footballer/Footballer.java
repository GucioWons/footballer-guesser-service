package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.entity.Club;

public class Footballer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String nationality;
    private Club club;
    private Integer number;
    private Position position;

    public Footballer(Integer id, String firstName, String lastName, String nationality, Club club, Integer number, Position position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
