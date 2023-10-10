package com.example.conquercrux.service.cart;

import com.example.conquercrux.domain.Cart;
import com.example.conquercrux.mapper.cart.CartMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private CartMapper cartMapper;

    @Override
    public void addToCart(Cart cart) {
        log.info("CartService.addToCart > cart = {}", cart);

        cartMapper.addToCart(cart);
    }

    @Override
    public Cart readCartItem(String product_name) {
        log.info("CartService.readCartItem > product_name = {}", product_name);

        return cartMapper.readCartItem(product_name);
    }

    @Override
    public boolean updateCartItem(Cart cart) {
        log.info("CartService.updateCartItem > cart = {}", cart);

        return cartMapper.updateCartItem(cart) == 1;
    }

    @Override
    public boolean deleteCartItem(String member_id, String product_name) {
        log.info("CartService.deleteCartItem > member_id = {}, product_name = {}", member_id, product_name);

        return cartMapper.deleteCartItem(member_id, product_name) == 1;
    }

    @Override
    public List<Cart> getCartItemsByMemberId(String member_id) {
        log.info("CartService.getCartItemsByMemberId > member_id = {}", member_id);

        return cartMapper.getCartItemsByMemberId(member_id);
    }

    @Override
    public int getMemberTotalAmount(String member_id) {
        log.info("getMemberTotalAmount");

        return cartMapper.getMemberTotalAmount(member_id);
    }
}
