package com.studies.hexagonal.application.port.input.usecases.address;

import com.studies.hexagonal.application.dto.request.AddressRequest;
import com.studies.hexagonal.application.port.output.persistence.repository.AddressRepository;
import com.studies.hexagonal.domain.model.Address;

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
