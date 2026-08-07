package com.studies.hexagonal.shared.exceptions;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String message){
        super(message);
    }
    
}
