package com.studies.hexagonal.application.port.input.usecases.item;

import com.studies.hexagonal.application.dto.request.ItemRequest;
import com.studies.hexagonal.application.port.input.usecases.user.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.domain.model.Item;

public class AddItemUseCase {
    
    private final ItemRepository repository;

    public AddItemUseCase(ItemRepository repository){
        this.repository = repository;
    }

    public Item execute(ItemRequest request){
        Item item = new Item();
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        item.setQuantity(request.getQuantity());

        return repository.add(item);
    }
}
