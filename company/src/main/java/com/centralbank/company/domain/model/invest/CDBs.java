package com.centralbank.company.domain.model.invest;

import java.math.BigDecimal;

public class CDBs {

    private Long id;
    private Long userId;
    private BigDecimal amount;
    private BigDecimal annualRate;
    private int years;
    private BigDecimal expectedGain;

    public CDBs(Long userId, BigDecimal amount, BigDecimal annualRate, int years, BigDecimal expectedGain) {
        this.userId = userId;
        this.amount = amount;
        this.annualRate = annualRate;
        this.years = years;
        this.expectedGain = expectedGain;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getAnnualRate() {
        return annualRate;
    }

    public int getYears() {
        return years;
    }

    public BigDecimal getExpectedGain() {
        return expectedGain;
    }
}