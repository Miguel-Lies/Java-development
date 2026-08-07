package com.studies.hexagonal.application.port.input.usecases.item;

import com.studies.hexagonal.adapters.output.mapper.ItemMapper;
import com.studies.hexagonal.application.dto.request.ItemRequest;
import com.studies.hexagonal.application.dto.response.ItemResponse;
import com.studies.hexagonal.application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.domain.model.Item;

public class AddItemUseCase {
    
    private final ItemRepository repository;

    public AddItemUseCase(ItemRepository repository){
        this.repository = repository;
    }

    public ItemResponse execute(ItemRequest request){
        Item item = new Item();
        item.setSeller(request.getSellerid());
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        item.setQuantity(request.getQuantity());

        Item savedItem = repository.add(item);

        return ItemMapper.toResponse(savedItem);
    }
}
