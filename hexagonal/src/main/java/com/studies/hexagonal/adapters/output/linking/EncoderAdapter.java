package com.studies.hexagonal.adapters.output.linking;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.studies.hexagonal.application.port.output.persistence.interfaces.PasswordEncoderPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EncoderAdapter implements PasswordEncoderPort {

    private final PasswordEncoder encoder;

    @Override
    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
