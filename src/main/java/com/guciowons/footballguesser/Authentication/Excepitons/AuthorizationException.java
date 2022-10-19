package com.guciowons.footballguesser.Authentication.Excepitons;

public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String errorMessage){
        super(errorMessage);
    }
}
