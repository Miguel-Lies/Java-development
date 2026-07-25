package com.studies.hexagonal.application.port.input.usecases.payment;

public class DebitPayment implements PaymentMethod{

    private final String cardNumber;
    private final String bankAccount;

    public DebitPayment(String cardNumber, String bankAccount) {
        this.cardNumber = cardNumber;
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean isValid() {
        return cardNumber != null && cardNumber.replaceAll("\\s", "").length() == 16
                && bankAccount != null && !bankAccount.isBlank();
    }

    @Override
    public String describe() {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        return "Débito final " + lastFour;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }
    
}
