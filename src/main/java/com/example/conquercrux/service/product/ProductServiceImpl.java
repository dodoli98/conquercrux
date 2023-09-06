package com.example.conquercrux.service.product;

import com.example.conquercrux.domain.Product;
import com.example.conquercrux.mapper.product.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;


    @Override
    public void registerProduct(Product product, MultipartFile imageFile) throws IOException {
        log.info("ProductService.registerProduct > product = {}", product);

        // 이미지 파일을 바이트 배열로 변환
        byte[] imageBytes = imageFile.getBytes();

        // Product 객체에 이미지 바이트 배열 설정
        product.setProduct_image(imageBytes);

        // 데이터베이스에 상품 정보 저장
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
