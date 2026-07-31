package com.studies.hexagonal.application.port.input.usecases.payment;

public interface PaymentInterface {
    boolean isValid();
    String describe();
}

