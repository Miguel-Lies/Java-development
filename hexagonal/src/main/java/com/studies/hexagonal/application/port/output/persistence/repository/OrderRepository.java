package com.studies.hexagonal.application.port.output.persistence.repository;

import com.studies.hexagonal.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);
    Order delete(Order order);
}
