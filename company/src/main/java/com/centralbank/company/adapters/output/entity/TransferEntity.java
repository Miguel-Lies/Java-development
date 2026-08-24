package com.centralbank.company.adapters.output.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transfers")
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity senderId;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiverId;

    @Column(nullable = false)
    private LocalDateTime date;
}
