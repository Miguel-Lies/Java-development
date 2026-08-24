package com.centralbank.company.domain.model.user;

public class TransferKeys {
    private Long id;
    private Long userId;
    private String email;
    private String number;
    private String cpf;
    private String randomKey;

    public TransferKeys(Long userId, String email, String number, String cpf, String randomKey) {
        this.userId = userId;
        this.email = email;
        this.number = number;
        this.cpf = cpf;
        this.randomKey = randomKey;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
