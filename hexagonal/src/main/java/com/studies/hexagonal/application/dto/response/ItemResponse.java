package com.studies.hexagonal.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemResponse(
        UUID id,
        String name,
        int quantity,
        BigDecimal price
) {}