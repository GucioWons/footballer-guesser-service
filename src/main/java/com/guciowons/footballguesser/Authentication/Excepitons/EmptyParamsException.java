package com.guciowons.footballguesser.Authentication.Excepitons;

public class EmptyParamsException extends AuthorizationException{
    public EmptyParamsException(String errorMessage) {
        super(errorMessage);
    }
}
