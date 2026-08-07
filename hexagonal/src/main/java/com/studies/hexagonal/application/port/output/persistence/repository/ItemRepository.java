package com.studies.hexagonal.application.port.output.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.domain.model.Item;

public interface ItemRepository {
    Item add(Item item);
    Item delete(Item item);

    Optional<Item> findById(UUID id);
    List<Item> findByName(String name);

}
