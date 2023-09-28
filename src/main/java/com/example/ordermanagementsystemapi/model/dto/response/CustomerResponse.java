package com.example.ordermanagementsystemapi.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String fullName;
    private String email;
    private String telephone;
}
