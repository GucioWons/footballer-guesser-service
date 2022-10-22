package com.guciowons.footballguesser.Users.Score;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity<Score> createScore(@RequestParam Integer userId, @RequestParam Integer leagueId, @RequestParam Long points){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scoreService.createScore(userId, leagueId, points));
    }

    @PutMapping
    public ResponseEntity<Score> addPoints(@RequestParam Integer userId, @RequestParam Integer leagueId, @RequestParam Long points){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scoreService.addPoints(userId, leagueId, points));
    }
}
