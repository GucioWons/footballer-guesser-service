package com.guciowons.footballguesser.Users.Authentication.Excepitons;

public class EmptyParamsException extends AuthorizationException{
    public EmptyParamsException(String errorMessage) {
        super(errorMessage);
    }
}
