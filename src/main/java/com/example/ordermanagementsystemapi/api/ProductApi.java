package com.example.ordermanagementsystemapi.api;

import com.example.ordermanagementsystemapi.model.dto.request.CreateProductRequest;
import com.example.ordermanagementsystemapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        if (productService.doesProductExist(createProductRequest.getSkuCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product already exists.");
        }
        productService.createProduct(createProductRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully.");
    }
}
