package com.studies.hexagonal.application.port.input.usecases.order;

import java.util.UUID;

import com.studies.hexagonal.application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.domain.model.Order;
import com.studies.hexagonal.shared.enums.OrderStatus;
import com.studies.hexagonal.shared.exceptions.OrderNotFound;

public class CancelUseCase {

    private final OrderRepository repository;

    public CancelUseCase(OrderRepository repository){
        this.repository = repository;
    } 

    public OrderStatus CancelExecute(UUID id){
        Order entity = repository.findById(id)
        .orElseThrow(() -> new OrderNotFound("Order not found"));
        
            repository.delete(entity);

            return OrderStatus.CANCELED;
        }
}
