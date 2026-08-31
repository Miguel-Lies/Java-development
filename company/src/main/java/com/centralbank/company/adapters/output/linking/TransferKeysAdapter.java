package com.centralbank.company.adapters.output.linking;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.TransferKeysEntity;
import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.repository.TrasnferKeysEntityRepository;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.TransferKeysRepository;
import com.centralbank.company.domain.model.user.TransferKeys;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TransferKeysAdapter implements TransferKeysRepository {

    private final TrasnferKeysEntityRepository keyRepository;
    private final UserEntityRepository userRepository;

    @Override
    public TransferKeys save(TransferKeys transferKey) {
        UserEntity userEntity = userRepository.getReferenceById(transferKey.getUserId());

        TransferKeysEntity entity = new TransferKeysEntity(
                transferKey.getUserId(),
                userEntity,
                transferKey.getType());

        TransferKeysEntity savedKey = keyRepository.save(entity);

        return new TransferKeys(
                savedKey.getId(),
                savedKey.getUser().getId(),
                savedKey.getKeyType());
    }

    @Override
    public void delete(TransferKeys transferKey) {
        UserEntity userEntity = userRepository.getReferenceById(transferKey.getUserId());

        TransferKeysEntity entity = new TransferKeysEntity(
                transferKey.getUserId(),
                userEntity,
                transferKey.getType());

        keyRepository.delete(entity);
    }
}