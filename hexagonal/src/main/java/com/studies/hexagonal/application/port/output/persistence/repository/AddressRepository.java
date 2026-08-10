package com.studies.hexagonal.Application.port.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.Domain.model.Address;

public interface AddressRepository {
    Address save(Address address);
    Address delete(Address address);

    Optional <Address> findById(UUID id);
}
