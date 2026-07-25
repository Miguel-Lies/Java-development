package com.studies.hexagonal.adapters.output.linking;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.adapters.output.entity.UserEntity;
import com.studies.hexagonal.adapters.output.repository.UserEntityRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.UserRepository;
import com.studies.hexagonal.domain.model.User;

@Component
public class UserAdapter implements UserRepository {

    private final UserEntityRepository repository;

    public UserAdapter(UserEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {

        UserEntity entity = new UserEntity(user.getId(),
        user.getName(),
        user.getEmail(),
        user.getPassword());

        UserEntity savedEntity = repository.save(entity);

        return new User(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getEmail()
        );
    }

    @Override
    public User delete(User user) {

        UserEntity entity = new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );

        repository.delete(entity);

        return user;
    }

    @Override
    public Optional<User> findByID(UUID id) {

        return repository.findById(id)
                .map(entity -> new User(
                        entity.getId(),
                        entity.getEmail(),
                        entity.getName()
                ));
    }
}
