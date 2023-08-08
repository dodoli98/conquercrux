package com.example.conquercrux.mapper.delivery;

import com.example.conquercrux.domain.Delivery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {

    void createDelivery(Delivery delivery);

    Delivery readDelivery(Long delivery_id);

    int updateDelivery(Delivery delivery);

    int deleteDelivery(Long delivery_id);



}
