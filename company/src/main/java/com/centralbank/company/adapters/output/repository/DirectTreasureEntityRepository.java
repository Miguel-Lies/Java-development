package com.centralbank.company.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.DirectTreasureEntity;

public interface DirectTreasureEntityRepository extends JpaRepository<DirectTreasureEntity, Long> {
    
}
