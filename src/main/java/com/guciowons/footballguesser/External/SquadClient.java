package com.guciowons.footballguesser.External;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://api.football-data.org/v3", name = "SQUAD-CLIENT")
public interface SquadClient {
    @GetMapping("/teams/{teamId}")
    Squad getSquad(@RequestHeader("X-Auth-Token") String authorizationHeader, @PathVariable Integer teamId);

    @GetMapping("/competitions/{competition}/teams")
    Teams getTeams(@RequestHeader("X-Auth-Token") String authorizationHeader, @PathVariable String competition);
}
