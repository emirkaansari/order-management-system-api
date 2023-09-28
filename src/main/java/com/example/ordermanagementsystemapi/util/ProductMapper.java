package com.example.ordermanagementsystemapi.util;

import com.example.ordermanagementsystemapi.model.dao.Product;
import com.example.ordermanagementsystemapi.model.dto.response.ProductResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);
}
