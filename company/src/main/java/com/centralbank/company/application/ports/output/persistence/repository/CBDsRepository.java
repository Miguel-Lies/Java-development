package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.invest.CDBs;

public interface CBDsRepository {
    CDBs save(CDBs cdbs);
}
