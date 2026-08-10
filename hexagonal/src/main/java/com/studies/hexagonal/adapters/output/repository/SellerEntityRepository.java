package com.studies.hexagonal.Adapters.output.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.hexagonal.Adapters.output.entity.SellerEntity;

public interface SellerEntityRepository extends JpaRepository<SellerEntity, UUID>{
    
}
