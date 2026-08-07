package com.studies.hexagonal.application.port.input.usecases.order;

import java.util.UUID;

import com.studies.hexagonal.application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.domain.model.Order;
import com.studies.hexagonal.shared.enums.OrderStatus;
import com.studies.hexagonal.shared.exceptions.OrderNotFoundException;

public class CancelOrderUseCase {

    private final OrderRepository repository;

    public CancelOrderUseCase(OrderRepository repository){
        this.repository = repository;
    } 

    public OrderStatus execute(UUID id){
        Order entity = repository.findById(id)
        .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        
            repository.delete(entity);

            return OrderStatus.CANCELED;
        }
}
