package com.studies.hexagonal.Adapters.output.entity;

import java.math.BigDecimal;
import java.util.*;

import com.studies.hexagonal.Shared.enums.OrderStatus;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,unique = true)
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<ItemEntity> items;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private Date createdAt;
}
