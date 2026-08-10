package com.studies.hexagonal.Shared.exceptions;

public class OrderCancelledException extends RuntimeException {
    public OrderCancelledException(String message){
        super(message);
    }
}
