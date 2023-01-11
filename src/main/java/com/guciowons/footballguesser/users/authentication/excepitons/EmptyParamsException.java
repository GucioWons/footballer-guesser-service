package com.guciowons.footballguesser.users.authentication.excepitons;

public class EmptyParamsException extends AuthorizationException{
    public EmptyParamsException(String errorMessage) {
        super(errorMessage);
    }
}
