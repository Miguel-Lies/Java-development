package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.user.Transfers;

public interface TransferRepository {
    Transfers save(Transfers transfers);
    void delete(Transfers transfers);

    
}
