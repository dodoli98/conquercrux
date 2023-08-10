package com.example.conquercrux.service.product;

import com.example.conquercrux.domain.Product;
import com.example.conquercrux.mapper.product.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testRegisterProduct() {

        Product product = new Product();

        product.setProduct_name("상품예시1");
        product.setProduct_price(9898);
        product.setProduct_stock(100);

        productService.registerProduct(product);

        log.info("registered product = {}", product);

    }

    @Test
    public void testReadProduct() {
        log.info("read product = {}", productService.readProduct(4L));
    }

    @Test
    public void testUpdateProductName() {
        Product product = productService.readProduct(4L);

        product.setProduct_name("업데이트된 상품 예시");

        productService.updateProduct(product);
    }

    @Test
    public void testUpdateProductPrice() {
        Product product = productService.readProduct(4L);

        product.setProduct_price(100);

        productService.updateProduct(product);
    }

    @Test
    public void testUpdateProduct() {

        Product product = productService.readProduct(4L);

        product.setProduct_name("업데이트");
        product.setProduct_price(20);

        productService.updateProduct(product);
    }


    @Test
    public void testDeleteProduct() {
        log.info("deleted product = {}", productService.deleteProduct(4L));
    }

    @Test
    public void testGetProduct() {
        log.info("getProduct = {}", productService.getProduct());
    }
}