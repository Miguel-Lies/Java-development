package com.studies.hexagonal.adapters.output.persistence.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

import com.studies.hexagonal.domain.model.Item;
import com.studies.hexagonal.shared.enums.OrderStatus;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private List<Item> items;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private Date createdAt;
}
