package com.studies.hexagonal.shared.exceptions;

public class NotFoundAddress extends RuntimeException {
    public NotFoundAddress(String message){
        super(message);
    }
}