package com.studies.hexagonal.shared.exceptions;

public class OrderCancelledException extends RuntimeException {
    public OrderCancelledException(String message){
        super(message);
    }
}
