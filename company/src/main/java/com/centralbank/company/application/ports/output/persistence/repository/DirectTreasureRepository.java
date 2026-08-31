package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.invest.DirectTreasure;

public interface DirectTreasureRepository {
    DirectTreasure save(DirectTreasure directTreasury);
}
