package com.guciowons.footballguesser.Authentication.Excepitons;

public class EmailExistsException extends AuthorizationException{
    public EmailExistsException(String errorMessage) {
        super(errorMessage);
    }
}
