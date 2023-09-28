package com.example.ordermanagementsystemapi.model.dto.request;

import com.example.ordermanagementsystemapi.model.dao.OrderLine;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateOrderRequest {
    @NotBlank
    private String customerEmail;
    @NotNull
    private List<OrderLine> orderLine;
}