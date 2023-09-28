package com.example.ordermanagementsystemapi.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class OrderResponse {
    private Long id;
    private List<OrderLineResponse> orderLineResponse;
    private CustomerResponse customerResponse;
    private Date submissionDate;
}