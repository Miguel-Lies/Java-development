package com.studies.hexagonal.Application.port.input.usecases.item;

import java.util.List;

import com.studies.hexagonal.Application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.Domain.model.Item;
import com.studies.hexagonal.Shared.exceptions.NotFoundItemException;

public class FindItemUseCase {
    
    private final ItemRepository repository;

    public FindItemUseCase(ItemRepository repository){
        this.repository = repository;
    }

    public List<Item> execute(String name) {
    List<Item> items = repository.findByName(name);
    
    if (items.isEmpty()) {
        throw new NotFoundItemException("The item: "+name+" not found.");
    }
    
    return items;
    }
}
