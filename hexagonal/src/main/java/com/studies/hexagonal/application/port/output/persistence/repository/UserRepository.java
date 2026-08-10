package com.studies.hexagonal.Application.port.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.studies.hexagonal.Domain.model.User;

public interface UserRepository {
    User save(User user);
    User delete(User user);

    Optional<User> findById(UUID id);
}
