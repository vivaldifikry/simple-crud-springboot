package com.dev.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private int quantity;
    private double price;
    private int category;

}
