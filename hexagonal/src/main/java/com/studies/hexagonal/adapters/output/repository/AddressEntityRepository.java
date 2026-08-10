package com.studies.hexagonal.Adapters.output.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.hexagonal.Adapters.output.entity.AddressEntity;

public interface AddressEntityRepository extends JpaRepository<AddressEntity, UUID> {
    
}
