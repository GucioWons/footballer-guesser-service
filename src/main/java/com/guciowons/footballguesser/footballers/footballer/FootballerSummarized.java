package com.guciowons.footballguesser.footballers.footballer;

public class FootballerSummarized {
    private final String name;
    private final String nationality;
    private final Integer number;
    private final Position position;

    public FootballerSummarized(String name, String nationality, Integer number, Position position) {
        this.name = name;
        this.nationality = nationality;
        this.number = number;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public Integer getNumber() {
        return number;
    }

    public Position getPosition() {
        return position;
    }
}
