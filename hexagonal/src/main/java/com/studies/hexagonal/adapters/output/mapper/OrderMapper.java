package com.studies.hexagonal.adapters.output.mapper;

import com.studies.hexagonal.adapters.output.entity.ItemEntity;
import com.studies.hexagonal.adapters.output.entity.OrderEntity;
import com.studies.hexagonal.application.dto.response.ItemResponse;
import com.studies.hexagonal.application.dto.response.OrderResponse;
import com.studies.hexagonal.domain.model.Item;
import com.studies.hexagonal.domain.model.Order;

import java.util.List;

public class OrderMapper {

    public static OrderEntity toEntity(Order order) {
        List<ItemEntity> itemEntities = order.getItems().stream()
                .map(ItemMapper::toEntity)
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

        return new Order(
                entity.getId(),
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