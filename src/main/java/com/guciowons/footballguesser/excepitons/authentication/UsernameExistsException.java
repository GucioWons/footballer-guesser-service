package com.guciowons.footballguesser.excepitons.authentication;

import com.guciowons.footballguesser.excepitons.ServiceException;

public class UsernameExistsException extends ServiceException {
    public UsernameExistsException(String errorMessage) {
        super(errorMessage);
    }
}
