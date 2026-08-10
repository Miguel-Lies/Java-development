package com.studies.hexagonal.Application.port.input.usecases.payment;

public interface PaymentInterface {
    boolean isValid();
    String describe();
}

