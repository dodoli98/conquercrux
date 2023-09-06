package com.example.conquercrux.controller;


import com.example.conquercrux.domain.Product;
import com.example.conquercrux.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    // 상품 등록 페이지 이동
    @GetMapping("/register_product")
    public String showRegisterProductPage() {
        return "/product/register_product";
    }

    // 상품 업데이트 페이지 이동
    @GetMapping("/update_product")
    public String showUpdateProductPage(@RequestParam("id") Long id, Model model) {
        Product product = productService.readProduct(id);
        model.addAttribute("product", product);
        return "/product/update_product";
    }




    @GetMapping("/product_list")
    public String getProductList(Model model) {

        List<Product> productList = productService.getProduct();
        model.addAttribute("productList", productList);

        log.info("productController#getProduct()");


        return "/product/product_list";
    }

/*
    @PostMapping("/register_product")
    public String registerProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.registerProduct(product);

        return "redirect:/product_list";

 */

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
