package com.centralbank.company.adapters.output.entity;

import lombok.*;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "direct_treasure")
public class DirectTreasureEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private Long userId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal annualRate;

    @Column(nullable = false)
    private int years;

    @Column(nullable = false)
    private BigDecimal expectedGain;
}
