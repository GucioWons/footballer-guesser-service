package com.guciowons.footballguesser.Authentication.Excepitons;

public class UsernameExistsException extends AuthorizationException{
    public UsernameExistsException(String errorMessage) {
        super(errorMessage);
    }
}
