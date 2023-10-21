package com.guciowons.footballguesser.game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody CreateGameRequestDTO createGameRequestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(gameService.create(createGameRequestDTO));
    }

    @GetMapping
    public Game getOpenGame(@RequestBody GetOpenGameDTO getOpenGameDTO){
        return gameService.getOpenGame(getOpenGameDTO);
    }
}
