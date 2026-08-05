package com.studies.hexagonal.adapters.output.linking;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.entity.AddressEntity;
import com.studies.hexagonal.adapters.output.entity.UserEntity;
import com.studies.hexagonal.adapters.output.repository.AddressEntityRepository;
import com.studies.hexagonal.adapters.output.repository.UserEntityRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.AddressRepository;
import com.studies.hexagonal.domain.model.Address;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AddressAdapter implements AddressRepository {

    private final AddressEntityRepository repository;
    private final UserEntityRepository userRepository;

    @Override
    public Address save(Address address){
        UserEntity userEntity = userRepository.getReferenceById(address.getUserId());
        AddressEntity entity = new AddressEntity(
        address.getUserId(),
        userEntity,
        address.getCountry(),
        address.getPostalCode(),
        address.getState(),
        address.getCity(),
        address.getNeighborhood(),
        address.getStreet(),
        address.getNumber());

        AddressEntity savedAddress = repository.save(entity);
    
        return new  Address(
        savedAddress.getId(),
        savedAddress.getCountry(),
        savedAddress.getPostalCode(),
        savedAddress.getState(),
        savedAddress.getCity(),
        savedAddress.getNeighborhood(),
        savedAddress.getStreet(),
        savedAddress.getNumber());
    }

    @Override
    public Address delete(Address address){
        UserEntity userEntity = userRepository.getReferenceById(address.getUserId());

        AddressEntity entity = new AddressEntity(address.getUserId(),
        userEntity,
        address.getCountry(),
        address.getPostalCode(),
        address.getState(),
        address.getCity(),
        address.getNeighborhood(),
        address.getStreet(),
        address.getNumber());

        repository.delete(entity);

        return address;
    }
    
    @Override
public Optional<Address> findById(UUID id) {
    return repository.findById(id)
        .map(entity -> new Address(
            entity.getCountry(),
            entity.getPostalCode(),
            entity.getState(),
            entity.getCity(),
            entity.getNeighborhood(),
            entity.getStreet(),
            entity.getNumber()));
    }
}
