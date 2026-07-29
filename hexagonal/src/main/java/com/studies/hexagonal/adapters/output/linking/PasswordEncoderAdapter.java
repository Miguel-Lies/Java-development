package com.studies.hexagonal.adapters.output.linking;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.studies.hexagonal.application.port.output.persistence.interfaces.PasswordEncoderPort;

public class PasswordEncoderAdapter implements PasswordEncoderPort {

    private final PasswordEncoder encoder;

    public PasswordEncoderAdapter(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }
}
