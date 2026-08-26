package com.centralbank.company.application.ports.input.usecases;

import com.centralbank.company.application.dto.request.AddressRequest;
import com.centralbank.company.application.ports.output.persistence.repository.AddressRepository;
import com.centralbank.company.application.ports.output.persistence.repository.UserRepository;
import com.centralbank.company.domain.model.user.Address;
import com.centralbank.company.domain.model.user.User;
import com.centralbank.company.shared.exceptions.UserNotFoundException;

public class AddressUseCase {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressUseCase(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public Address save(AddressRequest request) {
        Address address = new Address(
                request.getUserId(),
                request.getCountry(),
                request.getPostalCode(),
                request.getState(),
                request.getCity(),
                request.getNeighborhood(),
                request.getNumber(),
                request.getComplement());

        return addressRepository.save(address);
    }

    public Address edit(AddressRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Address updatedAddress = new Address(
                request.getUserId(),
                request.getCountry(),
                request.getPostalCode(),
                request.getState(),
                request.getCity(),
                request.getNeighborhood(),
                request.getNumber(),
                request.getComplement());

        user.setAddress(updatedAddress);

        userRepository.save(user);

        return updatedAddress;
    }
}
