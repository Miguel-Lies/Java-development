package com.studies.hexagonal.Application.port.output.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.Domain.model.Item;

public interface ItemRepository {
    Item add(Item item);
    Item delete(Item item);

    Optional<Item> findById(UUID id);
    List<Item> findByName(String name);

}
