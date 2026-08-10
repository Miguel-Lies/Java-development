package com.studies.hexagonal.Application.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.studies.hexagonal.Shared.enums.OrderStatus;

public record OrderResponse(
        UUID id,
        UUID orderId,
        List<ItemResponse> items,
        OrderStatus status,
        BigDecimal totalAmount,
        Date createdAt
) {}