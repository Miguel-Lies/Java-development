package com.studies.hexagonal.Shared.exceptions;

public class NotFoundAddressException extends RuntimeException {
    public NotFoundAddressException(String message){
        super(message);
    }
}