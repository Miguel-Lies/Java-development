package com.studies.hexagonal.shared.exceptions;

public class NotFoundAddressException extends RuntimeException {
    public NotFoundAddressException(String message){
        super(message);
    }
}