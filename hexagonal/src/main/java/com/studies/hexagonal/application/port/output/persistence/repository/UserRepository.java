package com.studies.hexagonal.application.port.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.domain.model.User;

public interface UserRepository {
    Optional<User> findByID(UUID id);

    User save(User user);
    User delete(User user);
}
