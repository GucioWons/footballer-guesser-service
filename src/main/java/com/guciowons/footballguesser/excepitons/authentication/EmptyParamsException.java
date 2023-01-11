package com.guciowons.footballguesser.excepitons.authentication;

import com.guciowons.footballguesser.excepitons.ServiceException;

public class EmptyParamsException extends ServiceException {
    public EmptyParamsException(String errorMessage) {
        super(errorMessage);
    }
}
