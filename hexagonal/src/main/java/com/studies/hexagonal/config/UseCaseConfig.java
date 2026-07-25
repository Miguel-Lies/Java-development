package com.studies.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.studies.hexagonal.application.port.input.usecases.user.CreateUseCase;
import com.studies.hexagonal.application.port.input.usecases.user.DeleteUseCase;
import com.studies.hexagonal.application.port.output.persistence.repository.UserRepository;

@Configuration
public class UseCaseConfig {
    
    @Bean
    public CreateUseCase createUseCase(UserRepository repository){
        return new CreateUseCase(repository);
    }

    @Bean
    public DeleteUseCase deleteUseCase(UserRepository repository){
        return new DeleteUseCase(repository);
    }
}
