package com.studies.hexagonal.application.usecases.payment;

public class CreditCardPayment implements PaymentInterface {

    private final String cardNumber;
    private final String cardHolderName;
    private final String cvv;
    private final int installments;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, int installments) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.installments = installments;
    }

    @Override
    public boolean isValid() {
        return cardNumber != null && cardNumber.replaceAll("\\s", "").length() == 16
                && cvv != null && cvv.length() >= 3
                && installments >= 1 && installments <= 12;
    }

    @Override
    public String describe() {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        return "Cartão de crédito final %s em %dx".formatted(lastFour, installments);
    }

    public int getInstallments() {
        return installments;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    String getCvv() {
        return cvv;
    }
 
}
