package com.centralbank.company.domain.model.user;

public class Address {
    private Long id;
    private Long userId;
    private String country;
    private String postalCode;
    private String state;
    private String city;
    private String street;
    private String neighborhood;
    private String number;
    private String complement;

    public Address(Long userId, String country, String postalCode, String state, String city,
            String neighborhood, String number, String complement) {
        this.userId = userId;
        this.country = country;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
    }

    public Address(Long id, Long userId, String country, String postalCode, String state, String city, String street,
            String neighborhood, String number, String complement) {
        this.id = id;
        this.userId = userId;
        this.country = country;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
        this.street = street;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
