package com.guciowons.footballguesser.feign;

import java.util.List;

public class ExternalTeams {
    private List<ExternalTeam> teams;
    private ExternalCompetition competition;

    public List<ExternalTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<ExternalTeam> teams) {
        this.teams = teams;
    }

    public ExternalCompetition getCompetition() {
        return competition;
    }

    public void setCompetition(ExternalCompetition competition) {
        this.competition = competition;
    }

    public static class ExternalCompetition {
        private int id;
        private String name;

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
    }

    public static class ExternalTeam {
        private int id;
        private String name;
        private String tla;

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
    }
}
