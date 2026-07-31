package com.studies.hexagonal.application.port.input.usecases.payment;

public class PixPayment implements PaymentInterface{

    private final String pixKey;

    public PixPayment(String pixKey) {
        this.pixKey = pixKey;
    }

    @Override
    public boolean isValid() {
        return pixKey != null && !pixKey.isBlank();
    }

    @Override
    public String describe() {
        return "Pix (" + pixKey + ")";
    }

    public String getPixKey() {
        return pixKey;
    }
    
}
