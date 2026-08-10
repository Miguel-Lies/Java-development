package com.studies.hexagonal.Adapters.output.linking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.Adapters.output.entity.SellerEntity;
import com.studies.hexagonal.Adapters.output.mapper.ItemMapper;
import com.studies.hexagonal.Adapters.output.repository.SellerEntityRepository;
import com.studies.hexagonal.Application.port.output.persistence.repository.SellerRepository;
import com.studies.hexagonal.Domain.model.Item;
import com.studies.hexagonal.Domain.model.Seller;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SellerAdapter implements SellerRepository{
    
    private final SellerEntityRepository repository;

    @Override
    public Seller save(Seller seller) {
        SellerEntity entity = SellerEntity.builder()
            .id(seller.getId())
            .name(seller.getName())
            .nameEnterprise(seller.getNameOfEnterprise())
            .email(seller.getEmail())
            .cnpjOfEnterprise(seller.getCnpjOfEnterprise())
            .build();

        SellerEntity saved = repository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Seller delete(Seller seller) {
        repository.deleteById(seller.getId());
        return seller;
    }

    @Override
    public Optional<Seller> findById(UUID id) {
        return repository.findById(id)
            .map(this::toDomain);
    }

    private Seller toDomain(SellerEntity entity) {
    List<Item> items = entity.getProducts().stream()
            .map(ItemMapper::toDomain)
            .toList();

    return new Seller(
            entity.getId(),
            entity.getName(),
            entity.getNameEnterprise(),
            items,
            entity.getEmail(),
            entity.getCnpjOfEnterprise());
}
}
