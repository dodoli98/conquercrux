package com.example.conquercrux.service.cart;

import com.example.conquercrux.domain.Cart;
import com.example.conquercrux.mapper.cart.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CartServiceTest {
    @Autowired
    private CartService cartService;

    @Test
    public void testAddToCart() {
        Cart cart = new Cart();
        cart.setMember_id("1234");
        cart.setProduct_name("222");
        cart.setProduct_quantity(2);

        // Add to cart
        cartService.addToCart(cart);
    }

    @Test
    public void testReadItem() {
        log.info("read item = {}", cartService.readCartItem("222"));
    }


    @Test
    public void testUpdateItemQuantity() {
        Cart cart = cartService.readCartItem("업데이트");

        cart.setProduct_quantity(110);

        log.info("update price = {}", cartService.updateCartItem(cart));
    }

    @Test
    public void testDeleteItem() {
        log.info("delete item = {}", cartService.deleteCartItem("1234", "ProductA"));
    }


    @Test
    public void testGetCartItemsByMemberId() {
        log.info(cartService.getCartItemsByMemberId("1234").toString());

    }


}