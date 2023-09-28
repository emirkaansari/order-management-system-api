package com.example.ordermanagementsystemapi.util;

import com.example.ordermanagementsystemapi.model.dao.Order;
import com.example.ordermanagementsystemapi.model.dto.response.OrderResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse toOrderResponse(Order order);
}
