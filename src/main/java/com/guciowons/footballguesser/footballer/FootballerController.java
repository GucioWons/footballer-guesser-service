package com.guciowons.footballguesser.footballer;

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
                .body(footballerService.getFotballers());
    }

    @GetMapping(value = "/club/{club}")
    public ResponseEntity<List<Footballer>> getFootballersByClub(@PathVariable String club){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(footballerService.getFootballersByClub(club));
    }
}
