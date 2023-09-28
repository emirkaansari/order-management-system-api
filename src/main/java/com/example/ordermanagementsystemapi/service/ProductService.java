package com.example.ordermanagementsystemapi.service;

import com.example.ordermanagementsystemapi.model.dao.Product;
import com.example.ordermanagementsystemapi.model.dto.request.CreateProductRequest;
import com.example.ordermanagementsystemapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public boolean doesProductExist(Long skuCode) {
        return productRepository.existsById(skuCode);
    }

    public void createProduct(CreateProductRequest createProductRequest) {
        productRepository.save(Product.builder()
                .name(createProductRequest.getName())
                .skuCode(createProductRequest.getSkuCode())
                .unitPrice(createProductRequest.getUnitPrice())
                .build());
    }

}
