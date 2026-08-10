package com.studies.hexagonal.Domain.model;

import java.util.List;
import java.util.UUID;

public class Seller {
    
    private UUID id;
    private String name;
    private String nameOfEnterprise;
    private List<Item> products;
    private String email;
    private String cnpjOfEnterprise;

    
    public Seller(UUID id, String name, String nameOfEnterprise,List<Item> products, String email, String cnpjOfEnterprise) {
        this.id = id;
        this.name = name;
        this.nameOfEnterprise = nameOfEnterprise;
        this.products = products;
        this.email = email;
        this.cnpjOfEnterprise = cnpjOfEnterprise;
    }

    public List<Item> getProducts() {
        return products;
    }

    public void setProducts(List<Item> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfEnterprise() {
        return nameOfEnterprise;
    }

    public void setNameOfEnterprise(String nameOfEnterprise) {
        this.nameOfEnterprise = nameOfEnterprise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpjOfEnterprise() {
        return cnpjOfEnterprise;
    }

    public void setCnpjOfEnterprise(String cnpjOfEnterprise) {
        this.cnpjOfEnterprise = cnpjOfEnterprise;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
