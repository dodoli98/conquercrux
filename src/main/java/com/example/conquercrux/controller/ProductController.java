package com.example.conquercrux.controller;


import com.example.conquercrux.domain.Product;
import com.example.conquercrux.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    // 관리자 : 상품 등록 페이지 이동
    @GetMapping("/register_product")
    public String showRegisterProductPage() {
        return "/product/register_product";
    }

    // 관리자 : 상품 업데이트 페이지 이동
    @GetMapping("/update_product")
    public String showUpdateProductPage(@RequestParam("id") Long id, Model model) {
        Product product = productService.readProduct(id);
        model.addAttribute("product", product);
        return "/product/update_product";
    }

    // 클라이언트 : 상품페이지 이동
    // productType을 구분의 모델객체에 전달후 해당 타입의 제품만 화면에 출력
    @GetMapping("/product_page/{productType}")
    public String showProductPage(@PathVariable String productType, Model model) {
        // 선택된 상품 타입의 상품 리스트를 가져옵니다.
        List<Product> productList = productService.getProductByType(productType);

        // 모델에 데이터를 추가하여 Thymeleaf 템플릿에서 사용할 수 있도록 합니다.
        model.addAttribute("productList", productList);
        model.addAttribute("productType", productType);

        // 상품 타입 페이지로 이동합니다.
        return "/product/product_page";
    }


    @GetMapping("/product_list")
    public String getProductList(Model model) {
        log.info("productController#getProduct()");

        List<Product> productList = productService.getProduct();

        model.addAttribute("productList", productList);

        return "/product/product_list";
    }


    @PostMapping("/register_product")
    public String registerProduct(Product product, RedirectAttributes redirectAttributes,
                                  @RequestParam("file") MultipartFile file) throws IOException {
        productService.registerProduct(product, file);

        return "redirect:/product_list";
    }

    @GetMapping("/read_product")
    public String readProduct(@RequestParam("id") Long id, Model model) {

        Product product = productService.readProduct(id);

        model.addAttribute("product", product);

        return "/product/read_product";

    }

    @PostMapping("/update_product")
    public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("product_id") Long productId) {
        product.setProduct_id(productId);
        productService.updateProduct(product);
        log.info("Controller#Update");
        return "/product/read_product";
    }


    @PostMapping("/delete_product")
    public String deleteProduct(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);

        return "redirect:/product_list";
    }




}
