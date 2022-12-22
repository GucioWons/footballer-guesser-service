package com.guciowons.footballguesser.Users.Authentication.Excepitons;

public class EmailExistsException extends AuthorizationException{
    public EmailExistsException(String errorMessage) {
        super(errorMessage);
    }
}
