package com.example.conquercrux.domain;

import lombok.Data;

@Data
public class Cart {
    private String member_id;

    private String product_name;

    private int product_price;

    private int product_quantity;

    private int product_stock;

    // 각 상품의 가격 * 상품 수량
    private int total_price;

    // 각 member 의 total_price 의 총합
    private int total_amount;
}
