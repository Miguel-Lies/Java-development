package com.studies.hexagonal.Application.port.input.usecases.address;

import java.util.UUID;

import com.studies.hexagonal.Application.port.output.persistence.repository.AddressRepository;
import com.studies.hexagonal.Domain.model.Address;
import com.studies.hexagonal.Shared.exceptions.NotFoundAddressException;

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
   