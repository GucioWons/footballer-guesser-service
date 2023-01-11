package com.guciowons.footballguesser.users.authentication.excepitons;

public class EmailExistsException extends AuthorizationException{
    public EmailExistsException(String errorMessage) {
        super(errorMessage);
    }
}
