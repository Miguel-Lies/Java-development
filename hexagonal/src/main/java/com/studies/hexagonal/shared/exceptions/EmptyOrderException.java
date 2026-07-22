package com.studies.hexagonal.shared.exceptions;

public class EmptyOrderException extends RuntimeException{
    public EmptyOrderException(String message){
        super(message);
    }
    
}
