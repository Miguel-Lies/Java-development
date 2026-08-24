package com.centralbank.company.domain.model.invest;

import java.math.BigDecimal;

public class DirectTreasury {
    private BigDecimal invested;
    private double percentagePerYear;

    public DirectTreasury(BigDecimal invested) {
        this.invested = invested;
    }

    public BigDecimal getInvested() {
        return invested;
    }

    public void setInvested(BigDecimal invested) {
        this.invested = invested;
    }

    public double getPercentagePerYear() {
        return percentagePerYear;
    }


    public void setPercentagePerYear(double percentagePerYear) {
        this.percentagePerYear = percentagePerYear;
    }
}
