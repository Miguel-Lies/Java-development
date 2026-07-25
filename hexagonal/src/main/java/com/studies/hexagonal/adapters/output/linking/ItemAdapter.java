package com.studies.hexagonal.adapters.output.linking;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.entity.ItemEntity;
import com.studies.hexagonal.adapters.output.repository.ItemEntityRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.domain.model.Item;

@Component
public class ItemAdapter implements ItemRepository {

    private final ItemEntityRepository repository;

    public ItemAdapter(ItemEntityRepository repository){
        this.repository = repository;
    }

    @Override
    public Item save(Item item){
        ItemEntity entity = new ItemEntity(item.getId(),
        item.getName(),
        item.getQuantity(),
        item.getPrice());

        ItemEntity itemSaved = repository.save(entity);

        return new Item(itemSaved.getName(),
        itemSaved.getQuantity(),
        itemSaved.getPrice());
    }
    
    @Override
    public Item delete(Item item){
        ItemEntity entity = new ItemEntity(item.getId(),
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
