package com.studies.hexagonal.adapters.output.mapper;

import com.studies.hexagonal.adapters.output.entity.ItemEntity;
import com.studies.hexagonal.application.dto.response.ItemResponse;
import com.studies.hexagonal.domain.model.Item;

public class ItemMapper {

    public static ItemEntity toEntity(Item item) {
        return ItemEntity.builder()
                .name(item.getName())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
    }

    public static Item toDomain(ItemEntity entity) {
        return new Item(entity.getName(), entity.getQuantity(), entity.getPrice());
    }

    public static ItemResponse toResponse(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getQuantity(),
                item.getPrice());
    }
}