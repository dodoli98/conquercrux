package com.example.conquercrux.mapper.order;

import com.example.conquercrux.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void createOrder(Order order);

    Order readOrder(Long order_id);

    // int updateOrder(Order order);
    // TODO: 배송지 변경

    int deleteOrder(Long order_id);

}
