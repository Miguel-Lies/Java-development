package com.studies.hexagonal.Adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studies.hexagonal.Application.dto.request.AddressRequest;
import com.studies.hexagonal.Application.dto.response.AddressResponse;
import com.studies.hexagonal.Application.port.input.usecases.address.AddAddressUseCase;
import com.studies.hexagonal.Application.port.input.usecases.address.RemoveAddressUseCase;
import com.studies.hexagonal.Domain.model.Address;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddAddressUseCase add;

    private final RemoveAddressUseCase remove;

    @PostMapping("/add")
    public ResponseEntity<AddressResponse> add(@RequestBody AddressRequest request) {
        Address address = add.execute(request);

        return ResponseEntity.ok(AddressResponse.from(address));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam UUID id){
        remove.execute(id);

        return ResponseEntity.noContent().build();
    }

}
