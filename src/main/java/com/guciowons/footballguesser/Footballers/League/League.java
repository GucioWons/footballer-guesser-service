package com.guciowons.footballguesser.Footballers.League;

import javax.persistence.*;

@Entity
@Table(name = "league")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer externalId;
    private String name;

    public League(Integer externalId, String name) {
        this.externalId = externalId;
        this.name = name;
    }

    public League() {

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
}
