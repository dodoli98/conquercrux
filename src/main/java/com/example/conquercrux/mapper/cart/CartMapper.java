package com.example.conquercrux.mapper.cart;

import com.example.conquercrux.domain.Cart;
import com.example.conquercrux.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface CartMapper {

    void addToCart(Cart cart);

    void updateCartItem(Cart cart);

    void deleteCartItem(String member_id, String product_name);

    List<Cart> getCartItemsByMemberId(String member_id);
}