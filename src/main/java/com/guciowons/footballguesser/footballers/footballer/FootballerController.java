package com.guciowons.footballguesser.footballers.footballer;

import com.guciowons.footballguesser.footballers.league.LeagueSummarized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/footballers")
public class FootballerController {
    private final FootballerService footballerService;

    public FootballerController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @GetMapping(value = "/league/{leagueId}")
    public ResponseEntity<LeagueSummarized> getFootballersByLeague(@PathVariable Integer leagueId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(footballerService.getFootballersByLeague(leagueId));
    }
}
