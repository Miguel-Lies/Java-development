package com.centralbank.company.domain.model.user;

import java.math.BigDecimal;

public class BankAccount {
    private Long userId;
    private BigDecimal balance;

    public BankAccount(Long userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
