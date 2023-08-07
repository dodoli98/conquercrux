package com.example.conquercrux.mapper.product;

import com.example.conquercrux.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProductMapperTest {
    @Autowired
    private ProductMapper mapper;

    @Test
    public void testRegisterProduct() {

        Product product = new Product();

        product.setProduct_name("상품예시1");
        product.setProduct_price(9898);
        product.setProduct_stock(100);

        mapper.registerProduct(product);

        log.info("registered product = {}", product);

    }

    @Test
    public void testReadProduct() {
        log.info("read product = {}", mapper.readProduct(1L));
    }

    @Test
    public void testUpdateProductName() {
        Product product = mapper.readProduct(1L);

        product.setProduct_name("업데이트된 상품 예시");

        mapper.updateProduct(product);
    }

    @Test
    public void testUpdateProductPrice() {
        Product product = mapper.readProduct(1L);

        product.setProduct_price(100);

        mapper.updateProduct(product);
    }

    @Test
    public void testUpdateProduct() {

        Product product = mapper.readProduct(2L);

        product.setProduct_name("업데이트");
        product.setProduct_price(20);

        mapper.updateProduct(product);
    }

    @Test
    public void testDeleteProduct() {
        log.info("deleted product = {}", mapper.deleteProduct(1L));
    }

    @Test
    public void testGetProduct() {
        log.info("getProduct = {}", mapper.getProduct());
    }

}