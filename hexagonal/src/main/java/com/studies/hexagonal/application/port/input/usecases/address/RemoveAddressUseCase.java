package com.studies.hexagonal.application.port.input.usecases.address;

import java.util.UUID;

import com.studies.hexagonal.application.port.output.persistence.repository.AddressRepository;
import com.studies.hexagonal.domain.model.Address;
import com.studies.hexagonal.shared.exceptions.NotFoundAddressException;

public class RemoveAddressUseCase {
    private final AddressRepository repository;

    public RemoveAddressUseCase(AddressRepository repository){
        this.repository = repository;
    }

    public Address execute(UUID id){
        Address address = repository.findById(id)
        .orElseThrow(() -> new NotFoundAddressException("Not found Address"));

        return repository.delete(address);
    }
}
   