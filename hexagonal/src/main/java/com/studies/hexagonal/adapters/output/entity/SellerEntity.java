package com.studies.hexagonal.adapters.output.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sellers")
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String nameEnterprise;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> products = new ArrayList<>();

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String cnpjOfEnterprise;

}
