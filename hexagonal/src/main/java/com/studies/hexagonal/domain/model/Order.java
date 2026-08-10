package com.studies.hexagonal.Domain.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.studies.hexagonal.Shared.enums.OrderStatus;

public class Order {

    private UUID id;
    private UUID costumerId;
    private UUID orderID;
    private List<Item> items;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private Date createdAt;

    public Order(UUID id, UUID costumerId, UUID orderID, List<Item> items,
                 OrderStatus status, BigDecimal totalAmount, Date createdAt) {
        this.id = id;
        this.costumerId = costumerId;
        this.orderID = orderID;
        this.items = items;
        this.status = status;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
    }

    public Order() {
    }

    public static Order create(UUID costumerId, List<Item> items) {
        return new Order(
                UUID.randomUUID(),
                costumerId,
                UUID.randomUUID(),
                items,
                OrderStatus.PENDING,
                calculateTotal(items),
                new Date());
    }

    private static BigDecimal calculateTotal(List<Item> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(UUID costumerId) {
        this.costumerId = costumerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public UUID getOrderID() {
        return orderID;
    }



    public void setOrderID(UUID orderID) {
        this.orderID = orderID;
    }

    
}
