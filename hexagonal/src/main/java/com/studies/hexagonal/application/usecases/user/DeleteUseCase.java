package com.studies.hexagonal.application.usecases.user;

import java.util.UUID;

import com.studies.hexagonal.application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.domain.model.User;
import com.studies.hexagonal.shared.exceptions.NotFoundUser;

public class DeleteUseCase {

    private final UserRepository repository;

    public DeleteUseCase(UserRepository repository){
        this.repository = repository;
    }
    
    public void execute(UUID id){
        User delete = repository.findByID(id)
        .orElseThrow(() -> new NotFoundUser("Not found user"));

        repository.delete(delete);
    }

}
