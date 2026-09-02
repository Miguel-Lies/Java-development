package com.centralbank.company.adapters.output.linking;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.DirectTreasureEntity;
import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.repository.DirectTreasureEntityRepository;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.DirectTreasureRepository;
import com.centralbank.company.domain.model.invest.DirectTreasure;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Component 
public class DirectTreasureAdapter implements DirectTreasureRepository{
    
    private final DirectTreasureEntityRepository dRepository;
    private final UserEntityRepository userRepository;

    @Override 
    public  DirectTreasure  save(DirectTreasure directTreasure){
        UserEntity userId = userRepository.getReferenceById(directTreasure.getUserId());

        DirectTreasureEntity entity = new DirectTreasureEntity(
                directTreasure.getId(),
                userId.getId(),
                directTreasure.getAmount(),
                directTreasure.getAnnualRate(),
                directTreasure.getYears(),
                directTreasure.getExpectedGain());

        DirectTreasureEntity saved = dRepository.save(entity);

        return new DirectTreasure(
                saved.getUserId(),
                saved.getAmount(),
                saved.getAnnualRate(),
                saved.getYears(),
                saved.getExpectedGain());
    }
}
