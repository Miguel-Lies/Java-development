package com.studies.hexagonal.Adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.hexagonal.Adapters.output.entity.UserEntity;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
}
