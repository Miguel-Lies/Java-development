package com.centralbank.company.shared.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message){
        super(message);
    }
}
