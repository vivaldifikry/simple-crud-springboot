package com.dev.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private long id;

    @Column(name = "productname")
    private String name;

    @Column(name = "productquantity")
    private int quantity;

    @Column(name = "productprice")
    private double price;

    @Column(name = "productcategory")
    private int category;
}
