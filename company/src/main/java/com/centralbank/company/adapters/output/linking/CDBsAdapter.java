package com.centralbank.company.adapters.output.linking;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.CDBsEntity;
import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.repository.CDBsEntityRepository;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.CBDsRepository;
import com.centralbank.company.domain.model.invest.CDBs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CDBsAdapter implements CBDsRepository {

    private final CDBsEntityRepository cdbsRepository;
    private final UserEntityRepository userRepository;

    @Override
    public CDBs save(CDBs cdBs) {
        UserEntity userId = userRepository.getReferenceById(cdBs.getUserId());

        CDBsEntity entity = new CDBsEntity(
                cdBs.getId(),
                userId.getId(),
                cdBs.getAmount(),
                cdBs.getAnnualRate(),
                cdBs.getYears(),
                cdBs.getExpectedGain());

        CDBsEntity saved = cdbsRepository.save(entity);

        return new CDBs(
                saved.getUserId(),
                saved.getAmount(),
                saved.getAnnualRate(),
                saved.getYears(),
                saved.getExpectedGain());
    }
}
