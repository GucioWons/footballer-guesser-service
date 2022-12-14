package com.guciowons.footballguesser.Footballers.Footballer;

import com.guciowons.footballguesser.Footballers.League.LeagueSummarized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/footballers")
public class FootballerController {
    private final FootballerService footballerService;

    public FootballerController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @GetMapping
    public ResponseEntity<List<Footballer>> getFootballers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(footballerService.getFootballers());
    }

    @GetMapping(value = "/club/{clubId}")
    public ResponseEntity<List<Footballer>> getFootballersByClub(@PathVariable Integer clubId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(footballerService.getFootballersByClub(clubId));
    }

    @GetMapping(value = "/league/{leagueId}")
    public ResponseEntity<LeagueSummarized> getFootballersByLeague(@PathVariable Integer leagueId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(footballerService.getFootballersByLeague(leagueId));
    }
}
