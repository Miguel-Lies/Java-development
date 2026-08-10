package com.studies.hexagonal.Adapters.output.mapper;

import com.studies.hexagonal.Adapters.output.entity.ItemEntity;
import com.studies.hexagonal.Adapters.output.entity.OrderEntity;
import com.studies.hexagonal.Application.dto.response.ItemResponse;
import com.studies.hexagonal.Application.dto.response.OrderResponse;
import com.studies.hexagonal.Domain.model.Item;
import com.studies.hexagonal.Domain.model.Order;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final ItemMapper itemMapper;

    public OrderMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public OrderEntity toEntity(Order order) {
        List<ItemEntity> itemEntities = order.getItems().stream()
                .map(itemMapper::toEntity)
                .toList();

        return OrderEntity.builder()
                .id(order.getId())
                .orderId(order.getOrderID())
                .items(itemEntities)
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .createdAt(order.getCreatedAt())
                .build();
    }

    public static Order toDomain(OrderEntity entity) {
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

    public static OrderResponse toResponse(Order order) {
        List<ItemResponse> itemResponses = order.getItems().stream()
                .map(ItemMapper::toResponse)
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getOrderID(),
                itemResponses,
                order.getStatus(),
                order.getTotalAmount(),
                order.getCreatedAt());
    }
}