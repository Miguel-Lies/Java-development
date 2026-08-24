package com.centralbank.company.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.AddressEntity;

public interface AddressEntityRepository extends JpaRepository<AddressEntity, Long> {
    
}
