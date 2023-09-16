package com.example.conquercrux.service.product;

import com.example.conquercrux.domain.Product;
import com.example.conquercrux.mapper.product.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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

    /*
    @Override
    public List<Product> getProduct() {
        log.info("ProductService.getProductList");

        return productMapper.getProduct();
    }

     */

    @Override
    public List<Product> getProduct() {
        List<Product> products = productMapper.getProduct();
        for (Product product : products) {
            // 이미지 데이터를 BASE64로 인코딩하여 설정
            byte[] imageBytes = product.getProduct_image(); // 이미지 데이터 가져오기
            if (imageBytes != null) {
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                product.setProduct_base64_image(base64Image); // Product 객체에 BASE64 이미지 설정
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductByType(String product_type) {
        List<Product> products = productMapper.getProductByType(product_type);

        for (Product product : products) {
            // 이미지 데이터를 BASE64로 인코딩하여 설정
            byte[] imageBytes = product.getProduct_image(); // 이미지 데이터 가져오기
            if (imageBytes != null) {
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                product.setProduct_base64_image(base64Image); // Product 객체에 BASE64 이미지 설정
            }
        }
        return products;

    }
}
