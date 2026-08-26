package com.centralbank.company.application.ports.output.persistence.interfaces;

public interface PasswordEncoderPort {
    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
