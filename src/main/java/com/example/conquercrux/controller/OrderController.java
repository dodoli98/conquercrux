package com.example.conquercrux.controller;

import com.example.conquercrux.service.cart.CartService;
import com.example.conquercrux.service.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    // 주문이 완료(결제가 완료된 상태)된 상태일따 Order 객체에 상품정보를 저장 해야한다.
    // 따라서 결제 페이지에선 카트 서비스가 필요하다.
    @Autowired
    private CartService cartService;

    @GetMapping("/payment")
    public String paymentPage() {
        return "/order/payment" ;
    }
}
