package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.user.Withdrawals;

public interface WithdrawalsRepository {
    Withdrawals save(Withdrawals withdrawals);
    void delete(Withdrawals withdrawals);


}
