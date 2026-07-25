package com.studies.hexagonal.application.port.input.usecases.item;

import java.util.UUID;

import com.studies.hexagonal.application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.domain.model.Item;
import com.studies.hexagonal.shared.exceptions.NotFoundItem;

public class DeleteUseCase {

    private final ItemRepository repository;

    public DeleteUseCase(ItemRepository repository){
        this.repository = repository;
    }

    public void execute(UUID id){
        Item item = repository.findById(id)
        .orElseThrow(() -> new NotFoundItem("Not found item"));

        repository.delete(item);
    }
    
}
