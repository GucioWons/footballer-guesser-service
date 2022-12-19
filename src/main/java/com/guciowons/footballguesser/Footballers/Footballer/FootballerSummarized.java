package com.guciowons.footballguesser.Footballers.Footballer;

public class FootballerSummarized {
    private String name;
    private String nationality;
    private Integer number;
    private Position position;

    public FootballerSummarized(String name, String nationality, Integer number, Position position) {
        this.name = name;
        this.nationality = nationality;
        this.number = number;
        this.position = position;
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
