package com.studies.hexagonal.Shared.exceptions;

public class AddressNotFoundException extends RuntimeException  {
    public AddressNotFoundException(String message){
        super(message);
    }
}
