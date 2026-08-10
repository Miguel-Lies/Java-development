package com.studies.hexagonal.Shared.exceptions;

public class NotFoundItemException extends RuntimeException {
    public NotFoundItemException(String message){
        super(message);
    }
    
}
