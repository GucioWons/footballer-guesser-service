package com.guciowons.footballguesser.excepitons.authentication;

import com.guciowons.footballguesser.excepitons.ServiceException;

public class IncorrectLoginException extends ServiceException {
    public IncorrectLoginException(String errorMessage) {
        super(errorMessage);
    }
}
