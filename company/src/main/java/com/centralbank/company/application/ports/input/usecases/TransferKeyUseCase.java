package com.centralbank.company.application.ports.input.usecases;

import java.util.UUID;

import com.centralbank.company.application.dto.request.TransferKeysRequest;
import com.centralbank.company.application.ports.output.persistence.repository.TransferKeysRepository;
import com.centralbank.company.application.ports.output.persistence.repository.UserRepository;
import com.centralbank.company.domain.model.user.TransferKeys;
import com.centralbank.company.domain.model.user.User;
import com.centralbank.company.shared.exceptions.InvalidKeyException;
import com.centralbank.company.shared.exceptions.UserNotFoundException;

public class TransferKeyUseCase {

    private final TransferKeysRepository keyRepository;
    private final UserRepository userRepository;

    public TransferKeyUseCase(TransferKeysRepository keyRepository, UserRepository userRepository) {
        this.keyRepository = keyRepository;
        this.userRepository = userRepository;
    }

    public TransferKeys add(TransferKeysRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        String value = switch (request.getType()) {
            case EMAIL -> validateEmail(request.getValue());
            case PHONE -> validatePhone(request.getValue());
            case CPF -> validateCpf(request.getValue());
            case RANDOM -> UUID.randomUUID().toString();
        };

        TransferKeys key = new TransferKeys(
                user.getId(),
                request.getType(),
                value);
        return keyRepository.save(key);
    }

    private String validateEmail(String value) {
        if (value == null || !value.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidKeyException("E-mail inválido");
        }
        return value;
    }

    private String validatePhone(String value) {
        if (value == null || !value.matches("^\\+?[0-9]{10,13}$")) {
            throw new InvalidKeyException("Número de telefone inválido");
        }
        return value;
    }

    private String validateCpf(String value) {
        if (value == null || !value.matches("^[0-9]{11}$")) {
            throw new InvalidKeyException("CPF inválido");
        }

        return value;
    }

}
