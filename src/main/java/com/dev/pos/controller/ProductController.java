package com.dev.pos.controller;

import com.dev.pos.dto.ProductDTO;
import com.dev.pos.entity.ProductEntity;
import com.dev.pos.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @CrossOrigin
    public List<ProductDTO> findAllProducts(){
        return productService.findAllProducts();
    }

    @PostMapping
    @CrossOrigin
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @PutMapping
    @CrossOrigin
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Optional<ProductDTO> findProductById(@PathVariable("id") Long id){
        return Optional.ofNullable(productService.findById(id));
    }


    /*
    //TANPA DTO, HANYA ENTITY

    @GetMapping
    public List<ProductEntity> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> findProductById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity){
        return productService.saveProduct(productEntity);
    }

    @PutMapping
    public ProductEntity updateProduct(@RequestBody ProductEntity productEntity){
        return productService.updateProduct(productEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

     */

}
