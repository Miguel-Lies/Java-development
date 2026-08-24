package com.centralbank.company.adapters.output.linking;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.AddressEntity;
import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.repository.AddressEntityRepository;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.AddressRepository;
import com.centralbank.company.domain.model.user.Address;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AddressAdapter implements AddressRepository {

    private final AddressEntityRepository addressRepository;
    private final UserEntityRepository userRepository;

    @Override
    public Address save(Address address) {
        UserEntity userEntity = userRepository.getReferenceById(address.getUserId());

        AddressEntity entity = new AddressEntity(
                address.getId(),
                userEntity,
                address.getCountry(),
                address.getPostalCode(),
                address.getState(),
                address.getCity(),
                address.getNeighborhood(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement());

        AddressEntity savedAddress = addressRepository.save(entity);

        return new Address(
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
    public void delete(Address address) {
        UserEntity userEntity = userRepository.getReferenceById(address.getUserId());

        AddressEntity entity = new AddressEntity(
                address.getId(),
                userEntity,
                address.getCountry(),
                address.getPostalCode(),
                address.getState(),
                address.getCity(),
                address.getNeighborhood(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement());

        addressRepository.delete(entity);
    }
}
