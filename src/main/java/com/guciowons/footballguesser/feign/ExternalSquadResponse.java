package com.guciowons.footballguesser.feign;

import java.util.List;

public class ExternalSquadResponse {
    private ExternalSquadTeam team;
    private List<ExternalSquadPlayer> players;

    public ExternalSquadTeam getTeam() {
        return team;
    }

    public void setTeam(ExternalSquadTeam team) {
        this.team = team;
    }

    public List<ExternalSquadPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<ExternalSquadPlayer> players) {
        this.players = players;
    }
}
