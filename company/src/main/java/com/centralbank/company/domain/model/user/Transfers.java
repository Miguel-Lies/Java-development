package com.centralbank.company.domain.model.user;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transfers {
    private Long id;
    private BigDecimal amount;
    private Long sender;
    private Long receiver;
    private LocalDateTime date;

    public Transfers(Long id, BigDecimal amount, Long sender, Long receiver, LocalDateTime date) {
        this.id = id;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
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
