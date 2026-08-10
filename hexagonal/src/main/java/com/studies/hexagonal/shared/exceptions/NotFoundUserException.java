package com.studies.hexagonal.Shared.exceptions;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String message){
        super(message);
    }
    
}
