package com.studies.hexagonal.Application.port.input.usecases.item;

import com.studies.hexagonal.Adapters.output.mapper.ItemMapper;
import com.studies.hexagonal.Application.dto.request.ItemRequest;
import com.studies.hexagonal.Application.dto.response.ItemResponse;
import com.studies.hexagonal.Application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.Domain.model.Item;

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
