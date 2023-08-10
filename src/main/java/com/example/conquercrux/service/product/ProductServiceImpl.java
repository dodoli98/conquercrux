package com.example.conquercrux.service.product;

import com.example.conquercrux.domain.Product;
import com.example.conquercrux.mapper.product.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;

    @Override
    public void registerProduct(Product product) {
        log.info("ProductService.registerProduct > product = {}", product);

        productMapper.registerProduct(product);
    }

    @Override
    public Product readProduct(Long product_id) {
        log.info("ProductService.registerProduct > product = {}", product_id);


        return productMapper.readProduct(product_id);
    }

    @Override
    public boolean updateProduct(Product product) {
        log.info("ProductService.updateProduct > product = {}", product);

        return productMapper.updateProduct(product) == 1;
    }

    @Override
    public boolean deleteProduct(Long product_id) {
        log.info("ProductService.deleteProduct > product = {}", product_id);

        return productMapper.deleteProduct(product_id) == 1;
    }

    @Override
    public List<Product> getProduct() {
        log.info("ProductService.getProductList");

        return productMapper.getProduct();
    }
}
