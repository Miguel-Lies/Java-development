package com.studies.hexagonal.Application.port.input.usecases.address;

import com.studies.hexagonal.Application.dto.request.AddressRequest;
import com.studies.hexagonal.Application.port.output.persistence.repository.AddressRepository;
import com.studies.hexagonal.Domain.model.Address;

public class AddAddressUseCase {
    
    private final AddressRepository repository;

    public AddAddressUseCase(AddressRepository repository){
        this.repository = repository;
    }

    public Address execute(AddressRequest request){
        Address address = new Address(
        request.getCountry(),
        request.getPostalCode(),
        request.getState(),
        request.getCity(),
        request.getNeighborhood(),
        request.getStreet(),
        request.getNumber());

        return repository.save(address);
    }
}
