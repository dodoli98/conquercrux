package com.example.conquercrux.mapper.order;

import com.example.conquercrux.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderMapperTest {

    @Autowired
    private OrderMapper mapper;

    @Test
    public void testCreateOrder() {
        Order order = new Order();

        order.setMember_id("1234");
        order.setTotal_amount(12354351);
        order.setOrder_date(new Date(System.currentTimeMillis()));

        mapper.createOrder(order);

        log.info("order = {}", order);
    }

    @Test
    public void testReadOrder() {
        log.info("read Order = {}", mapper.readOrder(2L));
    }

    @Test
    public void testDeleteOrder() {
        log.info("deleted order = {}", mapper.deleteOrder(2L));
    }


}