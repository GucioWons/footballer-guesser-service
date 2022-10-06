package com.guciowons.footballguesser.entity;

public class League {
    private final Integer id;
    private String name;

    public League(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
