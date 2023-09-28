package com.example.ordermanagementsystemapi.api;

import com.example.ordermanagementsystemapi.model.dto.request.OrderLineUpdateRequest;
import com.example.ordermanagementsystemapi.service.OrderLineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderLine")
public class OrderLineApi {

    @Autowired
    private OrderLineService orderLineService;

    @PostMapping("/updateQuantity")
    public ResponseEntity updateProductQuantity(@Valid @RequestBody OrderLineUpdateRequest request) {
        if (orderLineService.updateQuantity(request)) {
            return ResponseEntity.status(HttpStatus.OK).body("Quantity update is successful.");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("OrderLine doesn't exist.");
    }
}
