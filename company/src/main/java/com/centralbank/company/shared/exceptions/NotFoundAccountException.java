package com.centralbank.company.shared.exceptions;

public class NotFoundAccountException extends RuntimeException {

    public NotFoundAccountException(String message) {
        super(message);
    }
    
}
