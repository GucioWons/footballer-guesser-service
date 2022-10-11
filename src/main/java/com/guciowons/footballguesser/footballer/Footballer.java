package com.guciowons.footballguesser.footballer;

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
    private Integer clubId;
    private Integer number;
    private Position position;

    public Footballer(Integer externalId, String name, String nationality, Integer clubId, Integer number, Position position) {
        this.externalId = externalId;
        this.name = name;
        this.nationality = nationality;
        this.clubId = clubId;
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

    public Integer getClubId() {
        return clubId;
    }

    public void setClub(Integer clubId) {
        this.clubId = clubId;
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
