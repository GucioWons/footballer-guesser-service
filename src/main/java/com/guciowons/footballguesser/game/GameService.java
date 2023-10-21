package com.guciowons.footballguesser.game;

import com.guciowons.footballguesser.footballers.footballer.Footballer;
import com.guciowons.footballguesser.footballers.footballer.FootballerRepository;
import com.guciowons.footballguesser.footballers.league.League;
import com.guciowons.footballguesser.footballers.league.LeagueRepository;
import com.guciowons.footballguesser.game.dto.AddGuessDTO;
import com.guciowons.footballguesser.game.dto.CreateGameRequestDTO;
import com.guciowons.footballguesser.game.dto.GetOpenGameDTO;
import com.guciowons.footballguesser.game.dto.GuessOutcomeDTO;
import com.guciowons.footballguesser.user.User;
import com.guciowons.footballguesser.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final LeagueRepository leagueRepository;
    private final FootballerRepository footballerRepository;
    private final GuessService guessService;

    public GameService(GameRepository gameRepository, UserRepository userRepository, LeagueRepository leagueRepository, FootballerRepository footballerRepository, GuessService guessService) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.leagueRepository = leagueRepository;
        this.footballerRepository = footballerRepository;
        this.guessService = guessService;
    }

    public Game create(CreateGameRequestDTO createGameRequestDTO) {
        User user = userRepository.findById(createGameRequestDTO.playerId()).orElseThrow();
        League league = leagueRepository.findById(createGameRequestDTO.leagueId()).orElseThrow();
        Footballer footballer = footballerRepository.findById(createGameRequestDTO.footballerId()).orElseThrow();
        Game game = new Game(user, league, footballer, new ArrayList<>(), false);
        return gameRepository.save(game);
    }

    public Game getOpenGame(GetOpenGameDTO getOpenGameDTO) {
        return gameRepository.findByPlayerIdAndLeagueId(getOpenGameDTO.playerId(), getOpenGameDTO.leagueId());
    }

    public GuessOutcomeDTO addGuessToGame(AddGuessDTO addGuessDTO) {
        Footballer footballer = footballerRepository.findById(addGuessDTO.footballerId()).orElseThrow();
        Game game = gameRepository.findById(addGuessDTO.gameId()).orElseThrow();
        guessService.create(footballer, game);
        return guessService.getGuessOutcome(footballer, game);
    }
}
