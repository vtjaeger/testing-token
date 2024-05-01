package com.security.controller;

import com.security.domain.product.Product;
import com.security.domain.product.ProductRequestDto;
import com.security.domain.product.ProductResponseDto;
import com.security.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDto body){
        Product newProduct = new Product(body);

        this.repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDto> productList = this.repository.findAll().stream().map(ProductResponseDto::new).toList();

        return ResponseEntity.ok(productList);
    }
}
