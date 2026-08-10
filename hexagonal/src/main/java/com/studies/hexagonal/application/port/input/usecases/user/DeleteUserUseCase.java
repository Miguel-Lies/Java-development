package com.studies.hexagonal.Application.port.input.usecases.user;

import java.util.UUID;

import com.studies.hexagonal.Application.port.output.persistence.repository.AddressRepository;
import com.studies.hexagonal.Application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.Application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.Domain.model.Address;
import com.studies.hexagonal.Domain.model.User;
import com.studies.hexagonal.Shared.exceptions.AddressNotFoundException;
import com.studies.hexagonal.Shared.exceptions.NotFoundUserException;

public class DeleteUserUseCase {

    private final UserRepository repository;
    private final AddressRepository addressRepository;

    public DeleteUserUseCase(UserRepository repository,
        AddressRepository addressRepository,
        ItemRepository itemRepository){
        this.repository = repository;
        this.addressRepository = addressRepository;
    }
    
    public void execute(UUID id){
        User delete = repository.findById(id)
        .orElseThrow(() -> new NotFoundUserException("Not found user"));

        Address addressDelete = addressRepository.findById(id)
        .orElseThrow(() -> new AddressNotFoundException("Address not found"));

        addressRepository.delete(addressDelete);

        repository.delete(delete);
        addressRepository.delete(addressDelete);
    }

}
