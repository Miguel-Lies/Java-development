package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.user.TransferKeys;

public interface TransferKeysRepository {
    TransferKeys save(TransferKeys transferKeys);
    void delete(TransferKeys transferKeys);
}
