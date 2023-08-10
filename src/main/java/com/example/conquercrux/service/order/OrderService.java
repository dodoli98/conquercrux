package com.example.conquercrux.service.order;

import com.example.conquercrux.domain.Order;

public interface OrderService {
    /**
     * CREATE
     *
     * @param order    새로운 주문
     */
    void createOrder(Order order);

    /**
     * READ
     *
     * @param order_id  읽을 주문의 id
     */
    Order readOrder(Long order_id);

    /**
     * DELETE
     *
     * @param order_id  취소할 주문의 id
     */
    boolean deleteOrder(Long order_id);

}
