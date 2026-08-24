package com.centralbank.company.domain.model.saved;

import java.math.BigDecimal;

public class box {
    private BigDecimal totalSaved;

    public box(BigDecimal totalSaved) {
        this.totalSaved = totalSaved;
    }

    public BigDecimal getTotalSaved() {
        return totalSaved;
    }

    public void setTotalSaved(BigDecimal totalSaved) {
        this.totalSaved = totalSaved;
    } 
}
