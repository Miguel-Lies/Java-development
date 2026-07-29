package com.studies.hexagonal.application.port.input.usecases.payment;

import java.math.BigDecimal;

public class ProcessPayment {

    public static BigDecimal applyDiscount(BigDecimal amount, PaymentMethod method) {
    if (method instanceof PixPayment) {
        
        return amount.subtract(amount.multiply(new BigDecimal("0.05")));
    } if (method instanceof DebitPayment) {

        return amount.subtract(amount.multiply(new BigDecimal("0.02")));
    } if (method instanceof CreditCardPayment) {

        return amount;
    }
        return amount;
    }
    
}
