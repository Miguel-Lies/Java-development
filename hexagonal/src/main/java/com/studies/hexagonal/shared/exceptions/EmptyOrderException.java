package com.studies.hexagonal.Shared.exceptions;

public class EmptyOrderException extends RuntimeException{
    public EmptyOrderException(String message){
        super(message);
    }
    
}
