package com.guciowons.footballguesser.Users.Authentication.Excepitons;

public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String errorMessage){
        super(errorMessage);
    }
}
