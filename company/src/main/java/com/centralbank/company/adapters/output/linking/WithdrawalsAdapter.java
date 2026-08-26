package com.centralbank.company.adapters.output.linking;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.entity.WithdrawalsEntity;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.adapters.output.repository.WithdrawalsEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.WithdrawalsRepository;
import com.centralbank.company.domain.model.user.Withdrawals;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class WithdrawalsAdapter implements WithdrawalsRepository {

    private final WithdrawalsEntityRepository withdrawalsRepository;
    private final UserEntityRepository userRepository;

    @Override
    public Withdrawals save(Withdrawals withdrawals) {
        UserEntity userEntity = userRepository.getReferenceById(withdrawals.getUserId());

        WithdrawalsEntity entity = new WithdrawalsEntity(
                withdrawals.getId(),
                userEntity,
                withdrawals.getAmount(),
                withdrawals.getDate());

        WithdrawalsEntity savedEntity = withdrawalsRepository.save(entity);

        return new Withdrawals(
                savedEntity.getUserId().getId(),
                savedEntity.getAmount(),
                savedEntity.getDate());
    }

    @Override
    public void delete(Withdrawals withdrawals) {
        UserEntity userEntity = userRepository.getReferenceById(withdrawals.getUserId());

        WithdrawalsEntity entity = new WithdrawalsEntity(
                withdrawals.getId(),
                userEntity,
                withdrawals.getAmount(),
                withdrawals.getDate());

        withdrawalsRepository.delete(entity);
    }

}