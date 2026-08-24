package com.centralbank.company.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.WithdrawalsEntity;

public interface WithdrawalsEntityRepository extends JpaRepository<WithdrawalsEntity, Long>{
    
}
