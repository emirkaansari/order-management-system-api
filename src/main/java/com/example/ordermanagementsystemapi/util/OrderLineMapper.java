package com.example.ordermanagementsystemapi.util;

import com.example.ordermanagementsystemapi.model.dao.OrderLine;
import com.example.ordermanagementsystemapi.model.dto.response.OrderLineResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrderLineMapper {
    OrderLineResponse toOrderLineResponse(OrderLine orderLine);

    List<OrderLineResponse> toOrderLineResponseList(List<OrderLine> orderLines);
}

