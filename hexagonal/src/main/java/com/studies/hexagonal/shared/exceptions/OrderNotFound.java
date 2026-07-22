package com.studies.hexagonal.shared.exceptions;

public class OrderNotFound extends RuntimeException{
    public OrderNotFound(String message){
        super(message);
    }
    
}
