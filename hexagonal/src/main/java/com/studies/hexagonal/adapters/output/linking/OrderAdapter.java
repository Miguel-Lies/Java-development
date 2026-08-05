package com.studies.hexagonal.adapters.output.linking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.entity.ItemEntity;
import com.studies.hexagonal.adapters.output.entity.OrderEntity;
import com.studies.hexagonal.adapters.output.entity.UserEntity;
import com.studies.hexagonal.adapters.output.mapper.ItemMapper;
import com.studies.hexagonal.adapters.output.repository.OrderEntityRepository;
import com.studies.hexagonal.adapters.output.repository.UserEntityRepository;
import com.studies.hexagonal.application.port.input.usecases.user.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.domain.model.Item;
import com.studies.hexagonal.domain.model.Order;
import com.studies.hexagonal.shared.enums.OrderStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrderAdapter implements OrderRepository {

    private final OrderEntityRepository repository;
    private final UserEntityRepository userRepository;
    private final ItemMapper itemMapper;

    @Override
    public Order save(Order order) {
        UserEntity user = userRepository.getReferenceById(order.getId());

        List<ItemEntity> itemEntities = order.getItems().stream()
                .map(itemMapper::toEntity)
                .toList();

        OrderEntity entity = new OrderEntity(
                order.getId(),
                order.getOrderID(),
                user,
                itemEntities,
                order.getStatus(),
                order.getTotalAmount(),
                order.getCreatedAt());

        OrderEntity savedEntity = repository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public Order delete(Order order) {
        UserEntity user = userRepository.getReferenceById(order.getId());

        List<ItemEntity> itemEntities = order.getItems().stream()
                .map(itemMapper::toEntity)
                .toList();

        OrderEntity entity = new OrderEntity(
                order.getId(),
                order.getOrderID(),
                user,
                itemEntities,
                order.getStatus(),
                order.getTotalAmount(),
                order.getCreatedAt());

        repository.delete(entity);

        return new Order(
            order.getId(),
            order.getCostumerId(),
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

        return new Order(entity.getId(),
        entity.getUser().getId(),
        entity.getOrderId(),
        items,
        entity.getStatus(),
        entity.getTotalAmount(),
        entity.getCreatedAt());
    }
}