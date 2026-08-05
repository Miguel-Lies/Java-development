package com.studies.hexagonal.application.port.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.domain.model.Address;

public interface AddressRepository {
    Address save(Address address);
    Address delete(Address address);

    Optional <Address> findById(UUID id);
}
