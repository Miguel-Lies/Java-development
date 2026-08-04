package com.studies.hexagonal.application.port.input.usecases.user;

import java.util.UUID;

import com.studies.hexagonal.application.port.input.usecases.user.output.persistence.repository.UserRepository;
import com.studies.hexagonal.domain.model.User;
import com.studies.hexagonal.shared.exceptions.NotFoundUser;

public class DeleteUserUseCase {

    private final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository){
        this.repository = repository;
    }
    
    public void execute(UUID id){
        User delete = repository.findById(id)
        .orElseThrow(() -> new NotFoundUser("Not found user"));

        repository.delete(delete);
    }

}
