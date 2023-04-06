package com.neosoft.currency.exception;

public class AlreadyPresentException extends RuntimeException{
    public AlreadyPresentException(String message){
        super(message);
    }
}
