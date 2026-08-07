package com.studies.hexagonal.shared.exceptions;

public class NotFoundItemException extends RuntimeException {
    public NotFoundItemException(String message){
        super(message);
    }
    
}
