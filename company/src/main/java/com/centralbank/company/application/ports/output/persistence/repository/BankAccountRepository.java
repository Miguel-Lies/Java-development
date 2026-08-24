package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.user.BankAccount;

public interface BankAccountRepository {
    BankAccount save(BankAccount bankAccount);
}
