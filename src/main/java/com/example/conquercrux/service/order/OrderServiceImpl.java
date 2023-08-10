package com.example.conquercrux.service.order;

import com.example.conquercrux.domain.Order;
import com.example.conquercrux.mapper.order.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    // 매퍼주입
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        log.info("OrderService.createOrder > order = {}", order);

        orderMapper.createOrder(order);
    }

    @Override
    public Order readOrder(Long order_id) {
        log.info("OrderService.readOrder > order_id = {}", order_id);

        return orderMapper.readOrder(order_id);
    }

    @Override
    public boolean deleteOrder(Long order_id) {
        log.info("OrderService.deleteOrder > order_id = {}", order_id);

        return orderMapper.deleteOrder(order_id) == 1;
    }
}
