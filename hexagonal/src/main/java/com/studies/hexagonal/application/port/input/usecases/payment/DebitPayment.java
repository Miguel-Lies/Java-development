package com.studies.hexagonal.Application.port.input.usecases.payment;

public class DebitPayment implements PaymentInterface {

    private final String cardToken;
    private final String lastFourDigits;

    public DebitPayment(String cardToken, String lastFourDigits) {
        this.cardToken = cardToken;
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public boolean isValid() {
        return cardToken != null && !cardToken.isBlank();
    }

    @Override
    public String describe() {
        return "Final debit " + lastFourDigits;
    }

    public String getCardToken() {
        return cardToken;
    }
}