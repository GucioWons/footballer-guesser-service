package com.guciowons.footballguesser.feign;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://v3.football.api-sports.io", name = "SQUAD-CLIENT")
public interface ExternalSquadClient {
    @GetMapping("/players/squads")
    ExternalSquad getExternalSquad(@RequestHeader("x-apisports-key") String authorizationHeader, @RequestParam("team") Integer teamId);
}
