package com.guciowons.footballguesser.Footballers.External;

import java.util.List;

public class Teams {
    private List<Team> teams;
    private Competition competition;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public static class Competition {
        private int id;
        private String name;
        private String emblem;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmblem() {
            return emblem;
        }

        public void setEmblem(String emblem) {
            this.emblem = emblem;
        }
    }

    public static class Team {
        private int id;
        private String name;
        private String tla;
        private String crest;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTla() {
            return tla;
        }

        public void setTla(String tla) {
            this.tla = tla;
        }

        public String getCrest() {
            return crest;
        }

        public void setCrest(String crest) {
            this.crest = crest;
        }
    }
}
