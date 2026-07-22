package com.studies.hexagonal.shared.exceptions;

public class NotFoundUser extends RuntimeException {
    public NotFoundUser(String message){
        super(message);
    }
    
}
