package com.centralbank.company.application.ports.input.usecases;

import java.math.BigDecimal;

import com.centralbank.company.application.ports.output.persistence.repository.CBDsRepository;
import com.centralbank.company.application.ports.output.persistence.repository.DirectTreasureRepository;
import com.centralbank.company.application.ports.output.persistence.repository.UserRepository;
import com.centralbank.company.domain.model.invest.CDBs;
import com.centralbank.company.domain.model.invest.DirectTreasure;
import com.centralbank.company.domain.model.user.User;
import com.centralbank.company.domain.service.InvestmentsService;
import com.centralbank.company.shared.exceptions.UserNotFoundException;

public class InvestmentsUseCase {

    private final CBDsRepository cdbsRepository;
    private final DirectTreasureRepository dTreasureRepository;
    private final UserRepository userRepository;
    private final InvestmentsService service;

    public InvestmentsUseCase(CBDsRepository cdbsRepository, DirectTreasureRepository dTreasureRepository,
            UserRepository userRepository,
            InvestmentsService service) {
        this.cdbsRepository = cdbsRepository;
        this.userRepository = userRepository;
        this.service = service;
        this.dTreasureRepository = dTreasureRepository;
    }

    public CDBs cbds(BigDecimal amount, BigDecimal annualRate, int years, Long userId) {
        service.validateAmount(amount);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        BigDecimal expectedGain = service.simulation(amount, annualRate, years);

        CDBs cdb = new CDBs(
                user.getId(),
                amount,
                annualRate,
                years,
                expectedGain);

        return cdbsRepository.save(cdb);
    }

    public DirectTreasure directTreasure(BigDecimal amount, BigDecimal annualRate, int years, Long userId) {
        service.validateAmount(amount);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        BigDecimal expectedGain = service.simulation(amount, annualRate, years);

        DirectTreasure dTreasure = new DirectTreasure(
                user.getId(),
                amount,
                annualRate,
                years,
                expectedGain);

        return dTreasureRepository.save(dTreasure);
    }
}
