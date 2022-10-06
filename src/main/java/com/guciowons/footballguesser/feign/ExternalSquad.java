package com.guciowons.footballguesser.feign;

import java.util.List;

public class ExternalSquad {
    private List<ExternalSquadResponse> response;

    public List<ExternalSquadResponse> getResponse() {
        return response;
    }

    public void setResponse(List<ExternalSquadResponse> response) {
        this.response = response;
    }
}
