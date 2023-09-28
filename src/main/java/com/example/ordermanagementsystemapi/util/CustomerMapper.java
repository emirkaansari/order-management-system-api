package com.example.ordermanagementsystemapi.util;

import com.example.ordermanagementsystemapi.model.dao.Customer;
import com.example.ordermanagementsystemapi.model.dto.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse toCustomerResponse(Customer customer);
}
