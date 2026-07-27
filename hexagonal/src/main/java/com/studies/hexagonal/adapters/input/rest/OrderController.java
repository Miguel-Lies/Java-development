package com.studies.hexagonal.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.hexagonal.adapters.output.mapper.OrderMapper;
import com.studies.hexagonal.application.dto.request.OrderRequest;
import com.studies.hexagonal.application.dto.response.OrderResponse;
import com.studies.hexagonal.application.port.input.usecases.order.CancelOrderUseCase;
import com.studies.hexagonal.application.port.input.usecases.order.CreateOrderUseCase;
import com.studies.hexagonal.domain.model.Order;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Order")
public class OrderController {
    
    private final CreateOrderUseCase create;

    private final CancelOrderUseCase cancel;


    @PostMapping("/create")
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest request) {
        Order order = create.execute(request.getItems());
        OrderResponse response = OrderMapper.toResponse(order);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<OrderResponse> cancel(@PathVariable UUID id){
        cancel.execute(id);

        return ResponseEntity.noContent().build();
    }
}
