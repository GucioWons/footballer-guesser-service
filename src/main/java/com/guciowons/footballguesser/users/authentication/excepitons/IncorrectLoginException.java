package com.guciowons.footballguesser.users.authentication.excepitons;

public class IncorrectLoginException extends AuthorizationException{
    public IncorrectLoginException(String errorMessage) {
        super(errorMessage);
    }
}
