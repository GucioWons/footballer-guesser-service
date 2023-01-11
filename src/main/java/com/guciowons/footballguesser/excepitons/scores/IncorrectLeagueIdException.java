package com.guciowons.footballguesser.excepitons.scores;

import com.guciowons.footballguesser.excepitons.ServiceException;

public class IncorrectLeagueIdException extends ServiceException {
    public IncorrectLeagueIdException(String errorMessage) {
        super(errorMessage);
    }
}
