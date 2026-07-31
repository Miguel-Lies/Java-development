package com.studies.hexagonal.adapters.output.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.hexagonal.adapters.output.entity.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, UUID> {
}
