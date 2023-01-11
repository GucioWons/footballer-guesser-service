package com.guciowons.footballguesser.footballers.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://api.football-data.org", name = "SQUAD-CLIENT")
public interface SquadClient {
    @GetMapping("/v3/teams/{teamId}")
    Squad getSquad(@RequestHeader("X-Auth-Token") String authorizationHeader, @PathVariable Integer teamId);

    @GetMapping("/v4/competitions/{competition}/teams")
    Teams getTeams(@RequestHeader("X-Auth-Token") String authorizationHeader, @PathVariable String competition);
}
