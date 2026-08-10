package com.studies.hexagonal.Application.port.input.usecases.item;

import java.util.UUID;

import com.studies.hexagonal.Application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.Domain.model.Item;
import com.studies.hexagonal.Shared.exceptions.NotFoundItemException;

public class RemoveItemUseCase {

    private final ItemRepository repository;

    public RemoveItemUseCase(ItemRepository repository){
        this.repository = repository;
    }

    public Item execute(UUID id){
        Item item = repository.findById(id)
        .orElseThrow(() -> new NotFoundItemException("Not found item"));

        return repository.delete(item);
    }
    
}
