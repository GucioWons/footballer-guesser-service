package com.guciowons.footballguesser.feign;

import java.util.List;

public class ExternalSquad {
    private List<ExternalPlayer> squad;

    public List<ExternalPlayer> getSquad() {
        return squad;
    }

    public void setSquad(List<ExternalPlayer> squad) {
        this.squad = squad;
    }

    public static class ExternalPlayer {
        private Integer id;
        private String name;
        private String position;
        private String nationality;
        private Integer shirtNumber;

        public ExternalPlayer(Integer id, String name, String position, String nationality, Integer shirtNumber) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.nationality = nationality;
            this.shirtNumber = shirtNumber;
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

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public Integer getShirtNumber() {
            return shirtNumber;
        }

        public void setShirtNumber(Integer shirtNumber) {
            this.shirtNumber = shirtNumber;
        }
    }
}
