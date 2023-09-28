package com.example.ordermanagementsystemapi.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderLineResponse {
    private Long id;
    private ProductResponse productResponse;
    private int quantity;
}