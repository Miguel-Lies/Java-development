package com.studies.hexagonal.Application.port.output.persistence.interfaces;

public interface PasswordEncoderPort {
    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
