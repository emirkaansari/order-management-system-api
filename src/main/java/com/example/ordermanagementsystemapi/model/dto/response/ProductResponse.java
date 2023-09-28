package com.example.ordermanagementsystemapi.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long skuCode;
    private String name;
    private double unitPrice;
}
