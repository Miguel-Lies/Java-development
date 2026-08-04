package com.studies.hexagonal.adapters.output.mapper;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.entity.ItemEntity;
import com.studies.hexagonal.adapters.output.entity.SellerEntity;
import com.studies.hexagonal.adapters.output.repository.SellerEntityRepository;
import com.studies.hexagonal.application.dto.response.ItemResponse;
import com.studies.hexagonal.domain.model.Item;

@Component
public class ItemMapper {

    private final SellerEntityRepository sellerEntityRepository;

    public ItemMapper(SellerEntityRepository sellerEntityRepository) {
        this.sellerEntityRepository = sellerEntityRepository;
    }

    public ItemEntity toEntity(Item item) {
        SellerEntity sellerRef = sellerEntityRepository.getReferenceById(item.getSellerId());

        return ItemEntity.builder()
                .id(item.getId())
                .sellerId(sellerRef)
                .name(item.getName())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
    }

    public static Item toDomain(ItemEntity entity) {
        return new Item(
                entity.getId(),
                entity.getSellerId().getId(),
                entity.getName(),
                entity.getQuantity(),
                entity.getPrice());
    }

    public static ItemResponse toResponse(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getQuantity(),
                item.getPrice());
    }
}