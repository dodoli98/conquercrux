package com.example.conquercrux.domain;

import lombok.Data;

@Data
public class Cart {
    private String member_id;

    private String product_name;

    private int product_price;

    private int product_quantity;

    private int product_stock;
}
