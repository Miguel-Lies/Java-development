package com.centralbank.company.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.TransferKeysEntity;

public interface TrasnferKeysEntityRepository extends JpaRepository<TransferKeysEntity, Long>{
    
}
