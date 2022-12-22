package com.guciowons.footballguesser.Users.Authentication.Excepitons;

public class UsernameExistsException extends AuthorizationException{
    public UsernameExistsException(String errorMessage) {
        super(errorMessage);
    }
}
