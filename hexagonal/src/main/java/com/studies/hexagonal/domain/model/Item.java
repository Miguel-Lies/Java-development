package com.studies.hexagonal.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
    
    private UUID id;
    private UUID seller;
    private String name;
    private int quantity;
    private BigDecimal price;


    public Item(UUID seller, String name, int quantity, BigDecimal price) {
        this.seller = seller;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(UUID id, UUID seller, String name, int quantity, BigDecimal price) {
        this.id = id;
        this.seller = seller;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Item() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getSeller() {
        return seller;
    }

    public void setSeller(UUID sellerId) {
        this.seller = sellerId;
    }
    
}
