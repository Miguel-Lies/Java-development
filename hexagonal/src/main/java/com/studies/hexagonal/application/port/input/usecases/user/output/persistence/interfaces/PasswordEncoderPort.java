package com.studies.hexagonal.application.port.input.usecases.user.output.persistence.interfaces;

public interface PasswordEncoderPort {
    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
