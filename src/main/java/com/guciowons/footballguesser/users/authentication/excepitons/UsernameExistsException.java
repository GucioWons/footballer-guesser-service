package com.guciowons.footballguesser.users.authentication.excepitons;

public class UsernameExistsException extends AuthorizationException{
    public UsernameExistsException(String errorMessage) {
        super(errorMessage);
    }
}
