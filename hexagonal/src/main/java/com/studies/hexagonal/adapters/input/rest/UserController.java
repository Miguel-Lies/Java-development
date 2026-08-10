package com.studies.hexagonal.Adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.hexagonal.Application.dto.request.UserRequest;
import com.studies.hexagonal.Application.dto.response.UserResponse;
import com.studies.hexagonal.Application.port.input.usecases.user.CreateUserUseCase;
import com.studies.hexagonal.Application.port.input.usecases.user.DeleteUserUseCase;

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
@RequestMapping(name = "/user")
public class UserController {

    private final CreateUserUseCase create;

    private final DeleteUserUseCase delete;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        UserResponse response = create.execute(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        delete.execute(id);

        return ResponseEntity.noContent().build();
    }
}
