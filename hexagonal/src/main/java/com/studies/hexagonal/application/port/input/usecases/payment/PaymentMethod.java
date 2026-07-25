package com.studies.hexagonal.application.port.input.usecases.payment;

public interface PaymentMethod {
    boolean isValid();
    String describe();
}

