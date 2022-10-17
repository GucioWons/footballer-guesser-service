package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.Club.Club;

import javax.persistence.*;

@Entity
@Table(name = "footballer")
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer externalId;
    private String name;
    private String nationality;
    @ManyToOne
    private Club club;
    private Integer number;
    private Position position;

    public Footballer(Integer externalId, String name, String nationality, Club club, Integer number, Position position) {
        this.externalId = externalId;
        this.name = name;
        this.nationality = nationality;
        this.club = club;
        this.number = number;
        this.position = position;
    }

    public Footballer() {

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
