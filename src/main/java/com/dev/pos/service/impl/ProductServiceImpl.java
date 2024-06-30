package com.dev.pos.service.impl;

import com.dev.pos.dto.ProductDTO;
import com.dev.pos.entity.ProductEntity;
import com.dev.pos.repository.ProductRepository;
import com.dev.pos.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        //List<ProductEntity> entities = productRepository.findAll();
        //return entities.stream().map(this::convertToDTO).collect(Collectors.toList());

        List<ProductEntity> entities = productRepository.findAll();
        List<ProductDTO> dtos = new ArrayList<>();

        for (ProductEntity entity : entities) {
            ProductDTO dto = convertToDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        ProductEntity entity = convertToEntity(productDTO);
        ProductEntity savedEntity = productRepository.save(entity);
        return convertToDTO(savedEntity);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity existingProduct = optionalProduct.get();
            existingProduct.setName(productDTO.getName());
            existingProduct.setQuantity(productDTO.getQuantity());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setCategory(productDTO.getCategory());

            ProductEntity updatedProduct = productRepository.save(existingProduct);
            return convertToDTO(updatedProduct);
        } else {
            throw new NoSuchElementException("Product not found with id: " + id);
        }
    }

    @Override
    public void deleteProduct(Long id){
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            // Handle not found scenario, throw exception or log error
            throw new NoSuchElementException("Product not found with id: " + id);
        }
    }

    @Override
    public ProductDTO findById(Long id){
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return convertToDTO(optionalProduct.get());
        } else {
            // Handle not found scenario, throw exception or return null
            throw new NoSuchElementException("Product not found with id: " + id);
        }
    }

    private ProductDTO convertToDTO(ProductEntity entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getQuantity(),
                entity.getPrice(),
                entity.getCategory()
        );
    }

    private ProductEntity convertToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        return entity;
    }

    /*

    //TANPA DTO, HANYA ENTITY
    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

     */
}
