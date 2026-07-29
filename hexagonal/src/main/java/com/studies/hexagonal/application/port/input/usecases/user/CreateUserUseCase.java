package com.studies.hexagonal.application.port.input.usecases.user;

import com.studies.hexagonal.application.dto.request.UserRequest;
import com.studies.hexagonal.application.dto.response.UserResponse;
import com.studies.hexagonal.application.port.output.persistence.interfaces.PasswordEncoderPort;
import com.studies.hexagonal.application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.domain.model.User;

public class CreateUserUseCase {

    private final UserRepository repository;

    private PasswordEncoderPort encode;

    public CreateUserUseCase(UserRepository repository, PasswordEncoderPort encode){
        this.repository = repository;
        this.encode = encode;
    }

    public UserResponse execute(UserRequest request) {
        User create = new User();

        create.setName(request.getName());
        create.setEmail(request.getEmail());
        create.setPassword(encode.encode(request.getPassword()));

        User saved = repository.save(create);

        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail());
    }
}
