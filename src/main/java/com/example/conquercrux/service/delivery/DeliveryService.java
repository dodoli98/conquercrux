package com.example.conquercrux.service.delivery;

import com.example.conquercrux.domain.Delivery;

public interface DeliveryService {

    /**
     * CREATE : 새로운 배송 생성
     *
     * @param delivery
     */
    void createDelivery(Delivery delivery);

    /**
     * READ : id값을 통해 배송 확인
     *
     * @param delivery_id
     */
    Delivery readDelivery(Long delivery_id);

    /**
     * UDPATE : 배송 상태에 따라 주소지 변경
     *
     * @param delivery
     */
    boolean updateDelivery(Delivery delivery);

    /**
     * DELETE : 배송 상태에 따라 취소
     *
     * @param delivery_id
     */
    boolean deleteDelivery(Long delivery_id);



}
