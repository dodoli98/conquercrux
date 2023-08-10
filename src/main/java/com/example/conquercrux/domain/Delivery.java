package com.example.conquercrux.domain;

import lombok.Data;

@Data
public class Delivery {
    private Long delivery_id;

    private String member_id;

    private String member_address;

    private String delivery_status;

    private String delivery_memo;

    // 운송장 번호
    private String recipient_name;

}
