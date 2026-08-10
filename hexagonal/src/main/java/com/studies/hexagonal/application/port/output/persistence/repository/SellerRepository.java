package com.studies.hexagonal.Application.port.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.Domain.model.Seller;

public interface SellerRepository {
    Seller save(Seller seller);
    Seller delete(Seller seller);

    Optional<Seller> findById(UUID id);
}
