package com.example.ordermanagementsystemapi.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequest {
    @NotNull
    private Long skuCode;
    @NotBlank
    private String name;
    @NotNull
    private Double unitPrice;
}