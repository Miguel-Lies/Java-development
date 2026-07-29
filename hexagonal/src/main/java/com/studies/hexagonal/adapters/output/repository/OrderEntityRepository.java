package com.studies.hexagonal.adapters.output.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.hexagonal.adapters.output.entity.OrderEntity;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, UUID> {
}
