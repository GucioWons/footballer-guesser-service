package com.guciowons.footballguesser.game;

import com.guciowons.footballguesser.game.dto.AddGuessDTO;
import com.guciowons.footballguesser.game.dto.CreateGameRequestDTO;
import com.guciowons.footballguesser.game.dto.GetOpenGameDTO;
import com.guciowons.footballguesser.game.dto.GuessOutcomeDTO;
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

    @PutMapping
    public GuessOutcomeDTO addGuessToGame(@RequestBody AddGuessDTO addGuessDTO){
        return gameService.addGuessToGame(addGuessDTO);
    }
}
