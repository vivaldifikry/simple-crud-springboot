package com.dev.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="costumer")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CostumerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="costumerid")
    private long id;
    @Column(name="costumername")
    private String name;
    @Column(name="costumeraddress")
    private String address;
}
