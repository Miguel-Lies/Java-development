package com.studies.hexagonal.application.port.output.persistence.interfaces;

public interface PasswordEncoderPort {
    String encode(String rawPassword);
}
