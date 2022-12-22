package com.guciowons.footballguesser.Users.Authentication.Excepitons;

public class IncorrectLoginException extends AuthorizationException{
    public IncorrectLoginException(String errorMessage) {
        super(errorMessage);
    }
}
