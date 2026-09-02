package com.centralbank.company.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.centralbank.company.adapters.output.linking.EncoderAdapter;
import com.centralbank.company.application.ports.input.usecases.AddressUseCase;
import com.centralbank.company.application.ports.input.usecases.InvestmentsUseCase;
import com.centralbank.company.application.ports.input.usecases.TransferKeyUseCase;
import com.centralbank.company.application.ports.input.usecases.TransferUseCase;
import com.centralbank.company.application.ports.input.usecases.UserUseCase;
import com.centralbank.company.application.ports.output.persistence.repository.AddressRepository;
import com.centralbank.company.application.ports.output.persistence.repository.BankAccountRepository;
import com.centralbank.company.application.ports.output.persistence.repository.CBDsRepository;
import com.centralbank.company.application.ports.output.persistence.repository.DirectTreasureRepository;
import com.centralbank.company.application.ports.output.persistence.repository.TransferKeysRepository;
import com.centralbank.company.application.ports.output.persistence.repository.TransferRepository;
import com.centralbank.company.application.ports.output.persistence.repository.UserRepository;
import com.centralbank.company.domain.service.InvestmentsService;

@Configuration 
public class UseCaseConfig {

    @Bean
    public AddressUseCase addressUseCase(AddressRepository addressRepository, UserRepository userRepository){
        return new AddressUseCase(addressRepository, userRepository);
    }

    @Bean 
    public InvestmentsUseCase investmentsUseCase(CBDsRepository cbdsRepository, DirectTreasureRepository dTreasureRepository, UserRepository userRepository, InvestmentsService service){
        return new InvestmentsUseCase(cbdsRepository, dTreasureRepository, userRepository, service);
    }

    @Bean 
    public TransferKeyUseCase transferKeyUseCase(TransferKeysRepository tKeysRepository, UserRepository userRepository){
        return new TransferKeyUseCase(tKeysRepository, userRepository);
    }

    @Bean 
    public TransferUseCase transferUseCase(TransferRepository transferRepository, UserRepository userRepository, BankAccountRepository bAccountRepository){
        return new TransferUseCase(transferRepository, userRepository, bAccountRepository);
    }

    @Bean 
    public UserUseCase userUseCase(UserRepository userRepository, AddressRepository addressRepository, EncoderAdapter encode){
        return new UserUseCase(userRepository, encode, addressRepository);
    }
}
