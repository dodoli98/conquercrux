package com.example.conquercrux.service.order;

import com.example.conquercrux.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        Order order = new Order();

        order.setOrder_date(new Date(System.currentTimeMillis()));
        order.setMember_id("1111");
        order.setTotal_amount(1203);

        orderService.createOrder(order);

    }

    @Test
    public void testReadOrder() {
        log.info("read Order = {}", orderService.readOrder(4L));
    }

    @Test
    public void testDeleteOrder() {
        log.info("deleted order = {}", orderService.deleteOrder(4L));
    }



}