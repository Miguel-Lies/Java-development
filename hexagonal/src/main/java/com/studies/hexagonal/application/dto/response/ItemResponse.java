package com.studies.hexagonal.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemResponse{
    private UUID id;
    private UUID sellerid;
    private String name;
    private int quantity;
    private BigDecimal price;

    public ItemResponse(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public ItemResponse(UUID id, UUID sellerid, String name, int quantity, BigDecimal price) {
        this.id = id;
        this.sellerid = sellerid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public UUID getSellerid() {
        return sellerid;
    }

    public void setSellerid(UUID sellerid) {
        this.sellerid = sellerid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ItemResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
