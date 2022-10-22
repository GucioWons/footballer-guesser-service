package com.guciowons.footballguesser.Footballers.External;

import java.util.List;

public class Squad {
    private List<Player> squad;

    public List<Player> getSquad() {
        return squad;
    }

    public void setSquad(List<Player> squad) {
        this.squad = squad;
    }

    public static class Player {
        private Integer id;
        private String name;
        private String position;
        private String nationality;
        private Integer shirtNumber;

        public Player(Integer id, String name, String position, String nationality, Integer shirtNumber) {
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
