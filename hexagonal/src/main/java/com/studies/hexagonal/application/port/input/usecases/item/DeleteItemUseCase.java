package com.studies.hexagonal.application.port.input.usecases.item;

import java.util.UUID;

import com.studies.hexagonal.application.port.input.usecases.user.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.domain.model.Item;
import com.studies.hexagonal.shared.exceptions.NotFoundItem;

public class DeleteItemUseCase {

    private final ItemRepository repository;

    public DeleteItemUseCase(ItemRepository repository){
        this.repository = repository;
    }

    public Item execute(UUID id){
        Item item = repository.findById(id)
        .orElseThrow(() -> new NotFoundItem("Not found item"));

        return repository.delete(item);
    }
    
}
