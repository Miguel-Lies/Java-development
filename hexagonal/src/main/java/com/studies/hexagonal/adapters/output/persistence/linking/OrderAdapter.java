package com.studies.hexagonal.adapters.output.persistence.linking;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.persistence.entity.OrderEntity;
import com.studies.hexagonal.application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.domain.model.Order;

@Component
public class OrderAdapter implements OrderRepository {
    
    private final OrderRepository repository;

    public OrderAdapter(OrderRepository repository){
        this.repository = repository;
    }

    @Override
    public Order save(Order order){
        OrderEntity entity = new OrderEntity(o);

    }
}
