package com.centralbank.company.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.centralbank.company.shared.exceptions.InvalidAmountException;

public class InvestmentsService {

    public BigDecimal simulation(BigDecimal amount, BigDecimal annualRate, int years) {
        return amount
                .multiply(annualRate)
                .multiply(BigDecimal.valueOf(years))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal finalAmount(BigDecimal amount, BigDecimal annualRate, int years) {
        return amount.add(simulation(amount, annualRate, years));
    }

    public void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
    }

}