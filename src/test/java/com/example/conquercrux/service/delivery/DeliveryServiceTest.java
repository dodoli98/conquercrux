package com.example.conquercrux.service.delivery;

import com.example.conquercrux.domain.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class DeliveryServiceTest {

    @Autowired
    private DeliveryService deliveryService;


    @Test
    public void testCreateDelivery() {
        Delivery delivery = new Delivery();

        delivery.setMember_id("1111");
        delivery.setDelivery_status("배송중");
        delivery.setDelivery_memo("배송 전 연락 부탁드립니다.");
        delivery.setRecipient_name("12344125");

        deliveryService.createDelivery(delivery);

        log.info("delivery = {}", delivery);
    }

    @Test
    public void testReadDelivery() {
        log.info("Read Delivery = {}", deliveryService.readDelivery(12L));
    }

    @Test
    public void testUpdateDeliveryStatus() {
        Delivery delivery = deliveryService.readDelivery(12L);

        delivery.setDelivery_status("배송완료");

        deliveryService.updateDelivery(delivery);

        log.info("delivery = {}", delivery);
    }

    @Test
    public void testUpdateDeliveryAddress() {
        Delivery delivery = deliveryService.readDelivery(12L);
        String deliveryAddress = delivery.getDelivery_status();

        if ("배송완료".equals(deliveryAddress)) {
            delivery.setMember_address("광주");
            deliveryService.updateDelivery(delivery); // 업데이트 메서드 호출

            log.info("Delivery updated: {}", delivery);
        } else {
            log.warn("배송이 시작되어 불가능합니다.");
        }
    }





}