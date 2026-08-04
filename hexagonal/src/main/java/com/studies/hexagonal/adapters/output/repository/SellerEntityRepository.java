package com.studies.hexagonal.adapters.output.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.hexagonal.adapters.output.entity.SellerEntity;

public interface SellerEntityRepository extends JpaRepository<SellerEntity, UUID>{
    
}
