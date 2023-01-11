package com.guciowons.footballguesser.excepitons.scores;

import com.guciowons.footballguesser.excepitons.ServiceException;

public class IncorrectTimeException extends ServiceException {
    public IncorrectTimeException(String errorMessage) {
        super(errorMessage);
    }
}
