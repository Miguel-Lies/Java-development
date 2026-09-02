package com.centralbank.company.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.CDBsEntity;

public interface CDBsEntityRepository extends  JpaRepository<CDBsEntity, Long> {
    
}
