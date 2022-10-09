package com.guciowons.footballguesser.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://api.football-data.org/v3", name = "SQUAD-CLIENT")
public interface ExternalSquadClient {
    @GetMapping("/teams/{teamId}")
    ExternalSquad getExternalSquad(@RequestHeader("X-Auth-Token") String authorizationHeader, @PathVariable Integer teamId);
}
