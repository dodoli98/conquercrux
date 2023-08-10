package com.example.conquercrux.service.delivery;

import com.example.conquercrux.domain.Delivery;
import com.example.conquercrux.mapper.delivery.DeliveryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private DeliveryMapper deliveryMapper;

    @Override
    public void createDelivery(Delivery delivery) {
        log.info("DeliveryService.createDelivery > delivery = {}", delivery);

        deliveryMapper.createDelivery(delivery);
    }

    @Override
    public Delivery readDelivery(Long delivery_id) {
        log.info("DeliveryService.readDelivery > delivery_id = {}", delivery_id);

        return deliveryMapper.readDelivery(delivery_id);
    }

    @Override
    public boolean updateDelivery(Delivery delivery) {
        log.info("DeliveryService.updateDelivery > delivery = {}", delivery);

        return deliveryMapper.updateDelivery(delivery) == 1;
    }

    @Override
    public boolean deleteDelivery(Long delivery_id) {
        log.info("DeliveryService.deleteDelivery > delivery_id = {}", delivery_id);

        return deliveryMapper.deleteDelivery(delivery_id) == 1;
    }
}
