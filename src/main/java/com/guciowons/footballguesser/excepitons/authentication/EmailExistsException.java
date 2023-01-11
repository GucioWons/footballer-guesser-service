package com.guciowons.footballguesser.excepitons.authentication;

import com.guciowons.footballguesser.excepitons.ServiceException;

public class EmailExistsException extends ServiceException {
    public EmailExistsException(String errorMessage) {
        super(errorMessage);
    }
}
