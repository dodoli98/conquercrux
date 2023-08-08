package com.example.conquercrux.mapper.cart;

import com.example.conquercrux.domain.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CartMapper {

    void addToCart(Cart cart);

    Cart readCartItem(String product_name);

    int updateCartItem(Cart cart);

    // 아이디값과 제품의 이름이 동시에 일치하는 레코드를 삭제
    int deleteCartItem(String member_id, String product_name);

    List<Cart> getCartItemsByMemberId(String member_id);
}