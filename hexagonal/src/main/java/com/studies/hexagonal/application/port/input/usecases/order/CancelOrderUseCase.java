package com.studies.hexagonal.Application.port.input.usecases.order;

import java.util.UUID;

import com.studies.hexagonal.Application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.Domain.model.Order;
import com.studies.hexagonal.Shared.enums.OrderStatus;
import com.studies.hexagonal.Shared.exceptions.OrderNotFoundException;

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
