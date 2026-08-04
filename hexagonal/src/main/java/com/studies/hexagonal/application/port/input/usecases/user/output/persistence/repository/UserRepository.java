package com.studies.hexagonal.application.port.input.usecases.user.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.domain.model.User;

public interface UserRepository {
    Optional<User> findById(UUID id);

    User save(User user);
    User delete(User user);
}
