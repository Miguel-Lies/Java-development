package com.studies.hexagonal.adapters.output.linking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.entity.ItemEntity;
import com.studies.hexagonal.adapters.output.entity.OrderEntity;
import com.studies.hexagonal.adapters.output.mapper.ItemMapper;
import com.studies.hexagonal.adapters.output.repository.OrderEntityRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.domain.model.Item;
import com.studies.hexagonal.domain.model.Order;
import com.studies.hexagonal.shared.enums.OrderStatus;

@Component
public class OrderAdapter implements OrderRepository {
    
    private final OrderEntityRepository repository;

    public OrderAdapter(OrderEntityRepository repository){
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        List<ItemEntity> itemEntities = order.getItems().stream()
                .map(ItemMapper::toEntity)
                .toList();

        OrderEntity entity = new OrderEntity(
                order.getId(),
                order.getOrderID(),
                itemEntities,
                order.getStatus(),
                order.getTotalAmount(),
                order.getCreatedAt());

        OrderEntity savedEntity = repository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
public Order delete(Order order) {
    List<ItemEntity> itemEntities = order.getItems().stream()
            .map(ItemMapper::toEntity)
            .toList();

    OrderEntity entity = new OrderEntity(
            order.getId(),
            order.getOrderID(),
            itemEntities,
            order.getStatus(),
            order.getTotalAmount(),
            order.getCreatedAt());

    repository.delete(entity);

    return new Order(
            order.getId(),
            order.getOrderID(),
            order.getItems(),
            OrderStatus.CANCELED,
            order.getTotalAmount(),
            order.getCreatedAt());
}

    @Override
    public Optional<Order> findById(UUID id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    private Order toDomain(OrderEntity entity) {
        List<Item> items = entity.getItems().stream()
                .map(ItemMapper::toDomain)
                .toList();

        return new Order(
                entity.getId(),
                entity.getOrderId(),
                items,
                entity.getStatus(),
                entity.getTotalAmount(),
                entity.getCreatedAt());
    }
}
