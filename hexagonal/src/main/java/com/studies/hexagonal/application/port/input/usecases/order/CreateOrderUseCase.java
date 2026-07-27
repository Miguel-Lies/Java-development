package com.studies.hexagonal.application.port.input.usecases.order;

import java.util.List;

import com.studies.hexagonal.domain.model.Order;
import com.studies.hexagonal.application.port.output.persistence.repository.OrderRepository;
import com.studies.hexagonal.domain.model.Item;
import com.studies.hexagonal.shared.exceptions.EmptyOrderException;

public class CreateOrderUseCase {
    
    private final OrderRepository repository;

    public CreateOrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(List<Item> items){
        if(items == null || items.isEmpty()){
            throw new EmptyOrderException("Empty order");
        }else{
            Order order = new Order();
        return repository.save(order);
    }
}

}
