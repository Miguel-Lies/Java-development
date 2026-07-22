package com.studies.hexagonal.application.usecases.user;

import com.studies.hexagonal.application.dto.request.UserRequest;
import com.studies.hexagonal.application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.domain.model.User;

public class CreateUseCase {

    private final UserRepository repository;

    public CreateUseCase(UserRepository repository){
        this.repository = repository;
    }

    public void execute(UserRequest request){
        User create = new User();

        create.setName(request.getName());
        create.setEmail(request.getEmail());
        create.setPassword(request.getPassword());

        repository.save(create);
    }
}
