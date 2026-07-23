package com.studies.hexagonal.adapters.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.hexagonal.adapters.output.persistence.entity.OrderEntity;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, UUID> {
}
