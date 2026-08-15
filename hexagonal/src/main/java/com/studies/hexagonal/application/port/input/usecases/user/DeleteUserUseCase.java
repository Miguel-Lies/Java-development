package com.studies.hexagonal.Application.port.input.usecases.user;

import java.util.UUID;
import com.studies.hexagonal.Application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.Domain.model.User;
import com.studies.hexagonal.Shared.exceptions.NotFoundUserException;

public class DeleteUserUseCase {

    private final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository){
        this.repository = repository;
    }
    
    public void execute(UUID id){
        User delete = repository.findById(id)
        .orElseThrow(() -> new NotFoundUserException("Not found user"));

        repository.delete(delete);
    }

}
