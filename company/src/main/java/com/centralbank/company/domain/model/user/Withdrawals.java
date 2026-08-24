package com.centralbank.company.domain.model.user;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Withdrawals {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private LocalDateTime date;

    public Withdrawals(Long userId, BigDecimal amount, LocalDateTime date) {
        this.userId = userId;
        this.amount = amount;
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
