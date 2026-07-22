package com.studies.hexagonal.application.dto.request;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.studies.hexagonal.domain.model.User;
import com.studies.hexagonal.shared.enums.OrderStatus;
import com.studies.hexagonal.domain.model.Item;

public class OrderRequest {

    private UUID id;
    private User userId;
    private UUID orderId;
    private List<Item> items;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private Date createAt;

    public OrderRequest(UUID id, User userId, UUID orderId, List<Item> items, OrderStatus status,
            BigDecimal totalAmount, Date createAt) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.items = items;
        this.status = status;
        this.totalAmount = totalAmount;
        this.createAt = createAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    
}
