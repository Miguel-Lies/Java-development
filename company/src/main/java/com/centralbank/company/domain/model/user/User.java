package com.centralbank.company.domain.model.user;

public class User {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private String randomKey;
    private Address address;
    private String password;

    public User(String name, String email, String cpf, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }


    public User(Long id, String name, String email, String cpf, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    public User(String name, String email, String cpf, String randomKey, Address address, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.randomKey = randomKey;
        this.address = address;
        this.password = password;
    }
    

    public User(String name, String email, String phone, String cpf, String randomKey, Address address,
            String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.randomKey = randomKey;
        this.address = address;
        this.password = password;
    }


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
