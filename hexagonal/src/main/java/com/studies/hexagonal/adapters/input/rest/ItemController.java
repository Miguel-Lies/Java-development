package com.studies.hexagonal.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.hexagonal.adapters.output.mapper.ItemMapper;
import com.studies.hexagonal.application.dto.request.ItemRequest;
import com.studies.hexagonal.application.dto.response.ItemResponse;
import com.studies.hexagonal.application.port.input.usecases.item.AddItemUseCase;
import com.studies.hexagonal.application.port.input.usecases.user.DeleteUserUseCase;
import com.studies.hexagonal.domain.model.Item;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    
    private final AddItemUseCase add;

    private final DeleteUserUseCase delete;

    @PostMapping("/create")
    public ResponseEntity<ItemResponse> create(@RequestBody ItemRequest request) {
        Item item = add.execute(request);
        ItemResponse response = ItemMapper.toResponse(item);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ItemResponse> delete(@PathVariable UUID id){
        delete.execute(id);

        return ResponseEntity.noContent().build();
    }
}
