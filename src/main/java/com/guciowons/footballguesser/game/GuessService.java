package com.guciowons.footballguesser.game;

import com.guciowons.footballguesser.footballers.footballer.Footballer;
import com.guciowons.footballguesser.game.dto.GuessOutcomeDTO;
import org.springframework.stereotype.Service;

@Service
public class GuessService {
    private final GuessRepository guessRepository;

    public GuessService(GuessRepository guessRepository) {
        this.guessRepository = guessRepository;
    }

    public void create(Footballer footballer, Game game) {
        Guess guess = new Guess();
        guess.setGame(game);
        guess.setFootballer(footballer);
        guessRepository.save(guess);
    }

    public GuessOutcomeDTO getGuessOutcome(Footballer footballer, Game game){
        return new GuessOutcomeDTO(
                footballer.equals(game.getAnswer()),
                footballer.getClub().equals(game.getAnswer().getClub()),
                footballer.getClub().getLeague().equals(game.getAnswer().getClub().getLeague()),
                footballer.getNationality().equals(game.getAnswer().getNationality()),
                footballer.getNumber().equals(game.getAnswer().getNumber()),
                footballer.getPosition().equals(game.getAnswer().getPosition()));
    }
}
