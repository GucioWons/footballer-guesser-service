package com.guciowons.footballguesser.game;

import com.guciowons.footballguesser.footballers.footballer.Footballer;
import com.guciowons.footballguesser.footballers.footballer.FootballerRepository;
import com.guciowons.footballguesser.footballers.league.League;
import com.guciowons.footballguesser.footballers.league.LeagueRepository;
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

    public GameService(GameRepository gameRepository, UserRepository userRepository, LeagueRepository leagueRepository, FootballerRepository footballerRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.leagueRepository = leagueRepository;
        this.footballerRepository = footballerRepository;
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
}
