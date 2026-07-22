package com.studies.hexagonal.domain.service;

import java.math.BigDecimal;

public class OrderService {

    public BigDecimal totalAmount(int quantity, BigDecimal amount) {
    return amount.multiply(BigDecimal.valueOf(quantity));
    }
}
