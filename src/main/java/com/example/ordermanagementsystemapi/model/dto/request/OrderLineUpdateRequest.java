package com.example.ordermanagementsystemapi.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderLineUpdateRequest {
    @NotNull
    private Long orderLineId;
    @NotNull
    private Integer newQuantity;
}
