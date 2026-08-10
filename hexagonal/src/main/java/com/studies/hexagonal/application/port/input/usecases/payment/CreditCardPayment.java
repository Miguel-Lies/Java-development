package com.studies.hexagonal.Application.port.input.usecases.payment;

public class CreditCardPayment implements PaymentInterface {

    private final String cardToken;
    private final String lastFourDigits;
    private final int installments;

    public CreditCardPayment(String cardToken, String lastFourDigits, int installments) {
        this.cardToken = cardToken;
        this.lastFourDigits = lastFourDigits;
        this.installments = installments;
    }

    @Override
    public boolean isValid() {
        return cardToken != null && !cardToken.isBlank()
                && installments >= 1 && installments <= 12;
    }

    @Override
    public String describe() {
        return "Card credit final %s at %dx".formatted(lastFourDigits, installments);
    }

    public String getCardToken() {
        return cardToken;
    }

    public int getInstallments() {
        return installments;
    }
}