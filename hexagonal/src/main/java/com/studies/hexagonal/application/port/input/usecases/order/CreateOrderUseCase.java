package com.studies.hexagonal.Application.port.input.usecases.order;

import java.util.List;
import java.util.UUID;

import com.studies.hexagonal.Application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.Domain.model.Item;
import com.studies.hexagonal.Domain.model.Order;
import com.studies.hexagonal.Shared.exceptions.EmptyOrderException;

public class CreateOrderUseCase {
    
    private final OrderRepository repository;

    public CreateOrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(UUID customerId, List<Item> items){
        if(items == null || items.isEmpty()){
            throw new EmptyOrderException("Empty order");
        }
            Order order = Order.create(customerId, items);
            
        return repository.save(order);
    }
}
