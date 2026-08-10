package com.studies.hexagonal.Application.port.input.usecases.user;

import com.studies.hexagonal.Application.dto.request.UserRequest;
import com.studies.hexagonal.Application.dto.response.UserResponse;
import com.studies.hexagonal.Application.port.output.persistence.interfaces.PasswordEncoderPort;
import com.studies.hexagonal.Application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.Domain.model.User;

public class CreateUserUseCase {

    private final UserRepository repository;

    private PasswordEncoderPort encoder;

    public CreateUserUseCase(UserRepository repository, PasswordEncoderPort encoder){
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserResponse execute(UserRequest request) {
        User create = new User();

        create.setName(request.getName());
        create.setEmail(request.getEmail());
        create.setPassword(encoder.encode(request.getPassword()));

        User saved = repository.save(create);

        return new UserResponse(saved.getId(),
        saved.getName(),
        saved.getEmail());
    }
}
