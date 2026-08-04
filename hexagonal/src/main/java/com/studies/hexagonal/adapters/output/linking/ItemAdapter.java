package com.studies.hexagonal.adapters.output.linking;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.entity.ItemEntity;
import com.studies.hexagonal.adapters.output.entity.SellerEntity;
import com.studies.hexagonal.adapters.output.repository.ItemEntityRepository;
import com.studies.hexagonal.adapters.output.repository.SellerEntityRepository;
import com.studies.hexagonal.application.port.input.usecases.user.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.domain.model.Item;

@Component
public class ItemAdapter implements ItemRepository {

    private final ItemEntityRepository repository;
    private final SellerEntityRepository sellerRepository;

    public ItemAdapter(ItemEntityRepository repository, SellerEntityRepository sellerRepository){
        this.repository = repository;
        this.sellerRepository = sellerRepository;
    }

    @Override
public Item add(Item item) {
    SellerEntity seller = sellerRepository.getReferenceById(item.getSellerId());

    ItemEntity entity = new ItemEntity(
            item.getId(),
            seller,
            item.getName(),
            item.getQuantity(),
            item.getPrice());

    ItemEntity itemSaved = repository.save(entity);

    return new Item(
            itemSaved.getId(),
            itemSaved.getSellerId().getId(),
            itemSaved.getName(),
            itemSaved.getQuantity(),
            itemSaved.getPrice());
}
    
    @Override
    public Item delete(Item item){
        SellerEntity seller = sellerRepository.getReferenceById(item.getSellerId());

        ItemEntity entity = new ItemEntity(
        item.getId(),
        seller,
        item.getName(),
        item.getQuantity(),
        item.getPrice());

        repository.delete(entity);

        return item;
    }

    @Override
    public Optional<Item> findById(UUID id){
        return repository.findById(id)
        .map(entity -> new Item(
            entity.getId(),
            entity.getName(),
            entity.getQuantity(),
            entity.getPrice()
        ));
    }
}
