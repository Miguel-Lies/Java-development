package com.studies.hexagonal.adapters.output.persistence.linking;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.persistence.entity.OrderEntity;
import com.studies.hexagonal.adapters.output.persistence.repository.OrderEntityRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.domain.model.Order;
import com.studies.hexagonal.shared.enums.OrderStatus;

@Component
public class OrderAdapter implements OrderRepository {
    
    private final OrderEntityRepository repository;

    public OrderAdapter(OrderEntityRepository repository){
        this.repository = repository;
    }

    @Override
    public Order save(Order order){
        OrderEntity entity = new OrderEntity(order.getId(),
        order.getOrderID(),
        order.getItems(),
        order.getStatus(),
        order.getTotalAmount(),
        order.getCreatedAt());

        OrderEntity savedOrder = repository.save(entity);

        return new Order(savedOrder.getStatus());
    }

    @Override
    public Order delete(Order order){

        OrderEntity entity = new OrderEntity(order.getId(),
        order.getOrderID(),
        order.getItems(),
        order.getStatus(),
        order.getTotalAmount(),
        order.getCreatedAt());

        repository.delete(entity);

        return new Order(OrderStatus.CANCELED);
    }

}
