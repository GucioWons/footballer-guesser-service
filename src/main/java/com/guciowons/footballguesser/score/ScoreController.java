package com.guciowons.footballguesser.score;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity<ScoreResponse> createScore(@RequestParam Integer userId, @RequestParam Integer leagueId,
                                             @RequestParam Integer points) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scoreService.createScore(userId, leagueId, points));
    }

    @GetMapping
    public ResponseEntity<List<ScoreSummarized>> getScores(@RequestParam Optional<String> time,
                                                           @RequestParam Optional<Integer> leagueId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getScoresFromService(time, leagueId));
    }

    private List<ScoreSummarized> getScoresFromService(Optional<String> time, Optional<Integer> leagueId) {
        return leagueId
                .map(id -> time.map(times -> scoreService.getLeagueScoresWithTime(times, id))
                        .orElseGet(() -> scoreService.getLeagueScoresWithoutTime(id)))
                .orElseGet(() -> time.map(scoreService::getScoresWithTime)
                        .orElseGet(scoreService::getScoresWithoutTime));
    }
}
