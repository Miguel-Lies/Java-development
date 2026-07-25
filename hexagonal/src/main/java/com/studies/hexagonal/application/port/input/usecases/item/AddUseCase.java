package com.studies.hexagonal.application.port.input.usecases.item;

import com.studies.hexagonal.application.dto.request.ItemRequest;
import com.studies.hexagonal.application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.domain.model.Item;

public class AddUseCase {
    
    private final ItemRepository repository;

    public AddUseCase(ItemRepository repository){
        this.repository = repository;
    }

    public void execute(ItemRequest request){
        Item item = new Item();
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        item.setQuantity(request.getQuantity());

        repository.save(item);
    }
}
