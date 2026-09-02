package com.centralbank.company.adapters.output.linking;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.BankAccountEntity;
import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.repository.BankAccountEntityRepository;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.BankAccountRepository;
import com.centralbank.company.domain.model.user.BankAccount;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BankAccountAdapter implements BankAccountRepository {

        private final BankAccountEntityRepository bRepository;
        private final UserEntityRepository userRepository;

        @Override
        public BankAccount save(BankAccount bankAccount) {
                UserEntity userId = userRepository.getReferenceById(bankAccount.getUserId());

                BankAccountEntity entity = new BankAccountEntity(
                                bankAccount.getId(),
                                userId,
                                bankAccount.getBalance());

                BankAccountEntity saved = bRepository.save(entity);

                return new BankAccount(saved.getUserId().getId(),
                                saved.getBalance());
        }

        @Override
        public Optional<BankAccount> findById(Long id) {
                return bRepository.findById(id)
                                .map(entity -> new BankAccount(
                                                entity.getUserId().getId(),
                                                entity.getBalance()));
        }
}
