package com.guciowons.footballguesser.excepitons.scores;

import com.guciowons.footballguesser.excepitons.ServiceException;

public class IncorrectUserIdException extends ServiceException {
    public IncorrectUserIdException(String errorMessage) {
        super(errorMessage);
    }
}
