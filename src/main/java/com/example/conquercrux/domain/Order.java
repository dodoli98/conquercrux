package com.example.conquercrux.domain;

import lombok.Data;

import java.sql.Date;
import java.util.Map;

@Data
public class Order {
    private Long order_id;

    private Cart cart;

    private Member member;

    private boolean payment_status;

    private Date order_date;

    public Map<Product, Integer> getProductsAndQuantities() {
        return cart.getProductsAndQuantities();
    }

}
