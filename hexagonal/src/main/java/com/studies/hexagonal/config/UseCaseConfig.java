package com.studies.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.studies.hexagonal.application.port.input.usecases.address.AddAddressUseCase;
import com.studies.hexagonal.application.port.input.usecases.address.RemoveAddressUseCase;
import com.studies.hexagonal.application.port.input.usecases.item.AddItemUseCase;
import com.studies.hexagonal.application.port.input.usecases.item.FindItemUseCase;
import com.studies.hexagonal.application.port.input.usecases.item.RemoveItemUseCase;
import com.studies.hexagonal.application.port.input.usecases.order.CancelOrderUseCase;
import com.studies.hexagonal.application.port.input.usecases.order.CreateOrderUseCase;
import com.studies.hexagonal.application.port.input.usecases.user.CreateUserUseCase;
import com.studies.hexagonal.application.port.input.usecases.user.DeleteUserUseCase;
import com.studies.hexagonal.application.port.output.persistence.interfaces.PasswordEncoderPort;
import com.studies.hexagonal.application.port.output.persistence.repository.AddressRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.application.port.output.persistence.repository.UserRepository;



@Configuration
public class UseCaseConfig {
    
    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository repository, PasswordEncoderPort encode){
        return new CreateUserUseCase(repository, encode);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepository repository){
        return new DeleteUserUseCase(repository);
    }

    @Bean
    public AddItemUseCase addItemUseCase(ItemRepository repository) {
        return new AddItemUseCase(repository);
    }

    @Bean
    public RemoveItemUseCase deleteItemUseCase(ItemRepository repository){
        return new RemoveItemUseCase(repository);
    }

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderRepository repository){
        return new CreateOrderUseCase(repository);
    }

    @Bean
    public CancelOrderUseCase cancelOrderUseCase(OrderRepository repository){
        return new CancelOrderUseCase(repository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AddAddressUseCase addAddressUseCase(AddressRepository repository){
        return new AddAddressUseCase(repository);
    }

    @Bean
    public RemoveAddressUseCase removeAddressUseCase(AddressRepository repository){
        return new RemoveAddressUseCase(repository);
    }

    @Bean FindItemUseCase findItemUseCase(ItemRepository repository){
        return new FindItemUseCase(repository);
    }
}
