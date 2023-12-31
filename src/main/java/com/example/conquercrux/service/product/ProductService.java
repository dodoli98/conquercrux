package com.example.conquercrux.service.product;

import com.example.conquercrux.domain.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    /**
     * CREATE : 새로운 상품 등록
     *
     * @param product    등록할 상품의 정보
     */
    void registerProduct(Product product, MultipartFile multipartFile) throws IOException;

    /**
     * READ : 상품의 아이디를 통해 상품 불러오기
     *
     * @param product_id    읽어올 상품의 아이디
     */
    Product readProduct(Long product_id);


    /**
     * UPDATE : 상품정보 수정
     *
     * @param product       수정될 상품 정보
     */
    boolean updateProduct(Product product);

    /**
     * DELETE : 상품 레코드 삭제
     *
     * @param product_id    삭제할 상품의 아이디
     */
    boolean deleteProduct(Long product_id);

    /**
     * 모든 상품 레코드 반환
     */
    List<Product> getProduct();

    /**
     * 선택된 타입의 상품 LIST 반환
     *
     * @param product_type  반환할 상품들의 타입
     */
    List<Product> getProductByType(String product_type);
}
