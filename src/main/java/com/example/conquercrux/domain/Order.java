package com.example.conquercrux.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private Long order_id;

    private Date order_date;

    private String member_id;

    private int total_amount;

}
