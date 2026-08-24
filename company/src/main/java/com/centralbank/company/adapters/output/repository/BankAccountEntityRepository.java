package com.centralbank.company.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.BankAccountEntity;

public interface BankAccountEntityRepository extends JpaRepository<BankAccountEntity, Long>{
    
}
