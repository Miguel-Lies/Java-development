package com.studies.hexagonal.shared.exceptions;

public class NotFoundItem extends RuntimeException {
    public NotFoundItem(String message){
        super(message);
    }
    
}
