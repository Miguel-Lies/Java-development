package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.user.Address;

public interface AddressRepository {
    Address save(Address address);
    void delete(Address address);
    
}
