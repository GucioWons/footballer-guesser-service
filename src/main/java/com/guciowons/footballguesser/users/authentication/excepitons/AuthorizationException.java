package com.guciowons.footballguesser.users.authentication.excepitons;

public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String errorMessage){
        super(errorMessage);
    }
}
