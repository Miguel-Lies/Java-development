package com.studies.hexagonal.application.port.output.persistence.repository;

import com.studies.hexagonal.domain.model.Address;

public interface AddressRepository {
    Address save(Address address);
    Address delete(Address address);
}
