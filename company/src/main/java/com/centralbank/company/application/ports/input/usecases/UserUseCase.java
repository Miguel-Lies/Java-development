package com.centralbank.company.application.ports.input.usecases;

import com.centralbank.company.adapters.output.linking.EncoderAdapter;
import com.centralbank.company.application.dto.request.UserRequest;
import com.centralbank.company.application.dto.response.UserResponse;
import com.centralbank.company.application.ports.output.persistence.repository.UserRepository;
import com.centralbank.company.domain.model.user.User;
import com.centralbank.company.shared.exceptions.UserNotFoundException;

public class UserUseCase {

    private final UserRepository repository;
    private final EncoderAdapter encoder;

    public UserUseCase(UserRepository repository, EncoderAdapter encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserResponse create(UserRequest request) {
        User create = new User();

        create.setName(request.getName());
        create.setEmail(request.getEmail());
        create.setCpf(request.getCpf());
        create.setPassword(encoder.encode(request.getPassword()));

        User saved = repository.save(create);

        return new UserResponse(
                saved.getName(),
                saved.getEmail(),
                saved.getCpf());
    }

    public void delete(UserRequest request){
        User delete = repository.findById(request.getId())
        .orElseThrow(() -> new UserNotFoundException("User not found"));

        repository.delete(delete);
    }
}