package com.example.conquercrux.mapper.cart;

import com.example.conquercrux.domain.Cart;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CartMapperTest {

    @Autowired
    private CartMapper cartMapper;

    @Test
    public void testAddToCart() {
        Cart cart = new Cart();
        cart.setMember_id("1234");
        cart.setProduct_name("ProductA");
        cart.setProduct_price(10000);
        cart.setProduct_quantity(2);

        // Add to cart
        cartMapper.addToCart(cart);
    }

    @Test
    public void testReadItem() {
        log.info("read item = {}", cartMapper.readCartItem("ProductA"));
    }

    @Test
    public void testUpdateItemPrice() {
        Cart cart = cartMapper.readCartItem("ProductA");

        cart.setProduct_price(100);

        log.info("update price = {}", cartMapper.updateCartItem(cart));
    }

    @Test
    public void testUpdateItemQuantity() {
        Cart cart = cartMapper.readCartItem("ProductA");

        cart.setProduct_quantity(10);

        log.info("update price = {}", cartMapper.updateCartItem(cart));
    }

    @Test
    public void testDeleteItem() {
        log.info("delete item = {}", cartMapper.deleteCartItem("1234", "ProductA"));
    }


    @Test
    public void testGetCartItemsByMemberId() {
        log.info(cartMapper.getCartItemsByMemberId("1234").toString());

    }



}