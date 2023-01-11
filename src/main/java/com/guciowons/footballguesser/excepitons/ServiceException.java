package com.guciowons.footballguesser.excepitons;

public class ServiceException extends RuntimeException{
    public ServiceException(String errorMessage){
        super(errorMessage);
    }
}
