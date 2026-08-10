package com.studies.hexagonal.Adapters.output.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.hexagonal.Adapters.output.entity.ItemEntity;

import java.util.List;


public interface ItemEntityRepository extends JpaRepository<ItemEntity, UUID> {
    List<ItemEntity> findByName(String name);
}
