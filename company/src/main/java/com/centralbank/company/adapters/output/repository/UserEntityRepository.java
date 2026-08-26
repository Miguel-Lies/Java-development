package com.centralbank.company.adapters.output.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.company.adapters.output.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByStr(String information);
}
