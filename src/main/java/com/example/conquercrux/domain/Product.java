package com.example.conquercrux.domain;

import lombok.Data;

@Data
public class Product {
    private Long product_id;

    private String product_name;

    private int product_price;

    private int product_stock;
}
