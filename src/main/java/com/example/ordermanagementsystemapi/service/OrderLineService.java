package com.example.ordermanagementsystemapi.service;

import com.example.ordermanagementsystemapi.model.dto.request.OrderLineUpdateRequest;
import com.example.ordermanagementsystemapi.repository.OrderLineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;

    @Transactional
    public boolean updateQuantity(OrderLineUpdateRequest request) {
        return orderLineRepository.findOrderLineByIdAndUpdateQuantity(request.getOrderLineId(), request.getNewQuantity()) > 0;
    }
}
