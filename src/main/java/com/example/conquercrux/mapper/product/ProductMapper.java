package com.example.conquercrux.mapper.product;

import com.example.conquercrux.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    // CREATE
    void registerProduct(Product product);

    // READ : id
    Product readProduct(Long product_id);

    // UPDATE
    int updateProduct(Product product);

    // DELETE
    int deleteProduct(Long product_id);

    // 모든 상품 LIST
    List<Product> getProduct();

    // 선택된 타입의 상품 LIST
    List<Product> getProductByType(String product_type);

}
