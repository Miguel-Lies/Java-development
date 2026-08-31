package com.centralbank.company.shared.exceptions;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(message);
    }
    
}
