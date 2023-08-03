package com.example.conquercrux.domain;

import lombok.Data;

import java.util.Map;

@Data
public class Cart {
    private Long cart_id;

    private Product product;

    private User user;

    private Map<Product, Integer> productsAndQuantities;

}
