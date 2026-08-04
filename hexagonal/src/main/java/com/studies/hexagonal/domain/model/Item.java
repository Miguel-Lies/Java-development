package com.studies.hexagonal.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
    
    private UUID id;
    private UUID sellerId;
    private String name;
    private int quantity;
    private BigDecimal price;


    public Item(UUID sellerId, String name, int quantity, BigDecimal price) {
        this.sellerId = sellerId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(UUID id, UUID sellerId, String name, int quantity, BigDecimal price) {
        this.id = id;
        this.sellerId = sellerId;
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

    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }
    
}
