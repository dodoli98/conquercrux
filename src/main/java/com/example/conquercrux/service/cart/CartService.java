package com.example.conquercrux.service.cart;

import com.example.conquercrux.domain.Cart;

import java.util.List;

public interface CartService {
    /**
     * 카트에 제품을 추가
     *
     * @param cart
     */
    void addToCart(Cart cart);

    /**
     * READ : 카트 정보
     * @param product_name
     */
    Cart readCartItem(String product_name);

    /**
     * UPDATE : 카트의 제품 정보를 수정
     * @param cart
     */
    boolean updateCartItem(Cart cart);

    /**
     * DELETE : 카트에 있는 상품을 삭제
     *
     * @param member_id     카트에 접근할 회원 아이디
     * @param product_name  삭제하고자하는 상품의 이름
     */
    boolean deleteCartItem(String member_id, String product_name);

    /**
     * 카트에 있는 모든 상품을 조회
     *
     * @param member_id
     */
    List<Cart> getCartItemsByMemberId(String member_id);

    /**
     * 멤버별 상품 가격 총액
     *
     * @return
     */
    int getMemberTotalAmount(String member_id);
}
