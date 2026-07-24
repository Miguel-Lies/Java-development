package com.studies.hexagonal.application.port.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);
    Order delete(Order order);

    Optional<Order> findById(UUID id);
}
