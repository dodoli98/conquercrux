package com.example.conquercrux.mapper.delivery;

import com.example.conquercrux.domain.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DeliveryMapperTest {

    @Autowired
    private DeliveryMapper mapper;

    @Test
    public void testCreateDelivery() {
        Delivery delivery = new Delivery();

        delivery.setDelivery_address("서울");
        delivery.setDelivery_memo("배송전 연락 부탁합니다");
        delivery.setDelivery_status("배송중");
        delivery.setRecipient_name("123954838");

        mapper.createDelivery(delivery);

        log.info("delivery = {}", delivery);

    }

    @Test
    public void testReadDelivery() {
        mapper.readDelivery(1L);

    }

    @Test
    public void testUpdateDeliveryStatus() {
        Delivery delivery = mapper.readDelivery(1L);

        delivery.setDelivery_status("배송완료");

        mapper.updateDelivery(delivery);
    }

    @Test
    public void testUpdateDeliveryAddress() {
        Delivery delivery = mapper.readDelivery(1L);

        delivery.setDelivery_address("부산");

        mapper.updateDelivery(delivery);
    }

    @Test
    public void testDeleteDelivery() {
        log.info("delete delivery = {}", mapper.deleteDelivery(1L));

    }



}