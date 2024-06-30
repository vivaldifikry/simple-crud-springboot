package com.dev.pos.service;

import com.dev.pos.dto.ProductDTO;
import com.dev.pos.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    /*
    //TANPA DTO, HANYA ENTITY

    List<ProductEntity> findAllProducts();
    Optional<ProductEntity> findById(Long id);
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity updateProduct(ProductEntity productEntity);
    void deleteProduct(Long id);*/

    List<ProductDTO> findAllProducts();
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);
    <Optional>ProductDTO findById(Long id);
}
