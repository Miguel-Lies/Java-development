package com.centralbank.company.adapters.output.linking;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.UserRepository;
import com.centralbank.company.domain.model.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserAdapter implements UserRepository {

    private final UserEntityRepository repository;

    @Override
    public User save(User user) {
        UserEntity entity = new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getPassword());

        UserEntity savedEntity = repository.save(entity);

        return new User(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getEmail(),
                savedEntity.getCpf(),
                savedEntity.getPassword());
    }

    @Override
    public void delete(User user) {
        UserEntity entity = new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getPassword());

        repository.delete(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id)
                .map(entity -> new User(
                        entity.getName(),
                        entity.getEmail(),
                        entity.getCpf()));
    }

    @Override
    public Optional<User> findByStr(String information) {
        return repository.findByStr(information)
                .map(entity -> new User(
                        entity.getName(),
                        entity.getEmail(),
                        entity.getCpf()));
    }

}