package com.centralbank.company.adapters.output.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.TransferEntity;

public interface TransferEntityRepository extends JpaRepository<TransferEntity, Long>{
}
