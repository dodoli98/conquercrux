package com.example.conquercrux.controller;

import com.example.conquercrux.domain.Cart;
import com.example.conquercrux.domain.Product;
import com.example.conquercrux.service.cart.CartService;
import com.example.conquercrux.service.product.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add_to_cart")
    public String addToCart(@RequestParam Long id, HttpSession session, @RequestParam("quantity") int quantity) {
        String memberId = (String) session.getAttribute("member_id"); // 세션에서 사용자 ID 가져오기
        Product product = productService.readProduct(id); // 해당 제품 정보 가져오기

        // Cart 객체 생성
        Cart cart = new Cart();
        cart.setMember_id(memberId);
        cart.setProduct_name(product.getProduct_name());
        cart.setProduct_price(product.getProduct_price());
        cart.setProduct_quantity(quantity);
        cart.setProduct_stock(product.getProduct_stock());

        cartService.addToCart(cart); // Cart에 제품 추가

        return "redirect:/cart"; // 카트 페이지로 리다이렉트
    }

    @GetMapping("/cart")
    public String cartPage(HttpSession session, Model model) {
        String member_id = (String) session.getAttribute("member_id");
        log.info("cart Controller - member_id = {}", member_id);
        if (member_id != null) {
            List<Cart> cartList =  cartService.getCartItemsByMemberId(member_id);
            model.addAttribute("cartList", cartList);
            return "cart/cart";
        } else {
            return "home/home";
        }
    }

    @GetMapping("/deleteCartItem")
    public String deleteCartItem(HttpSession session, @RequestParam String product_name, RedirectAttributes redirectAttributes) {
        String member_id = (String) session.getAttribute("member_id");

        cartService.deleteCartItem(member_id, product_name);

        return "redirect:/cart";
    }



    @PostMapping("/updateCart")
    @ResponseBody // 이 어노테이션을 사용하여 응답 데이터가 JSON 또는 텍스트 형식인 경우를 처리합니다.
    public String updateCart(@RequestParam("productName") String productName,
                             @RequestParam("productQuantity") int productQuantity,
                             HttpSession session) {

        String member_id = (String) session.getAttribute("member_id");

        log.info("product_name = {}", productName);
        Cart cart = cartService.readCartItem(productName);

        cart.setMember_id(member_id);
        cart.setProduct_quantity(productQuantity);

        cartService.updateCartItem(cart);
        // 여기서 productName과 productQuantity를 사용하여 카트 업데이트 로직을 구현합니다.
        // 예를 들어, 카트 데이터베이스 업데이트 또는 세션에 데이터 저장을 수행할 수 있습니다.

        String jsonResponse = "{\"message\": \"수량이 업데이트되었습니다.\", \"updatedQuantity\": " + productQuantity + "}";
        return jsonResponse;
    }
}
