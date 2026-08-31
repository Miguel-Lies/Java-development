package com.centralbank.company.domain.model.invest;

import java.math.BigDecimal;

public class DirectTreasure {
    private Long id;
    private Long userId;
    private BigDecimal invested;
    private BigDecimal annualRate;
    private int years;
    private BigDecimal expectedGain;
    
    public DirectTreasure(Long id, Long userId, BigDecimal invested, BigDecimal annualRate, int years,
            BigDecimal expectedGain) {
        this.id = id;
        this.userId = userId;
        this.invested = invested;
        this.annualRate = annualRate;
        this.years = years;
        this.expectedGain = expectedGain;
    }

    public DirectTreasure(Long userId, BigDecimal invested, BigDecimal annualRate, int years, BigDecimal expectedGain) {
        this.userId = userId;
        this.invested = invested;
        this.annualRate = annualRate;
        this.years = years;
        this.expectedGain = expectedGain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getInvested() {
        return invested;
    }

    public void setInvested(BigDecimal invested) {
        this.invested = invested;
    }

    public BigDecimal getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(BigDecimal annualRate) {
        this.annualRate = annualRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public BigDecimal getExpectedGain() {
        return expectedGain;
    }

    public void setExpectedGain(BigDecimal expectedGain) {
        this.expectedGain = expectedGain;
    }

    

}