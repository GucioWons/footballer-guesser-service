package com.guciowons.footballguesser.Authentication.Excepitons;

public class IncorrectLoginException extends AuthorizationException{
    public IncorrectLoginException(String errorMessage) {
        super(errorMessage);
    }
}
