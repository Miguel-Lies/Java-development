package com.centralbank.company.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.centralbank.company.domain.service.InvestmentsService;

@Configuration
public class ServiceConfig {
    
    @Bean 
    public InvestmentsService investmentsService(){
        return new InvestmentsService();
    }
}
