package com.example.ordermanagementsystemapi.model.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SearchOrderRequest {
    private Long productSkuCode;
    private String customerEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
