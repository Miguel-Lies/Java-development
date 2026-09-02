package com.centralbank.company.application.ports.output.persistence.repository;

import java.util.Optional;

import com.centralbank.company.domain.model.user.BankAccount;

public interface BankAccountRepository {
    BankAccount save(BankAccount bankAccount);

    Optional<BankAccount> findById(Long id);
}
