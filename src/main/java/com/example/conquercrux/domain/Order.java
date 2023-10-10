package com.example.conquercrux.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private Long order_id;

    private Date order_date;

    private String member_id;

    // 상품 정보
    private String product_name;

    private int product_price;

    private int product_quantity;

    private int product_stock;

    // 결제 금액
    private int total_amount;

}
