package com.example.ordermanagementsystemapi.api;

import com.example.ordermanagementsystemapi.exception.InvalidRequestException;
import com.example.ordermanagementsystemapi.model.dto.request.CreateOrderRequest;
import com.example.ordermanagementsystemapi.model.dto.request.SearchOrderRequest;
import com.example.ordermanagementsystemapi.model.dto.response.OrderResponse;
import com.example.ordermanagementsystemapi.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderApi {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        try {
            orderService.createOrder(createOrderRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully.");
        } catch (InvalidRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request.");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderResponse>> searchOrder(@Valid @RequestBody SearchOrderRequest searchOrderRequest) {
        List<OrderResponse> orderResponse = orderService.searchOrder(searchOrderRequest);
        if (!orderResponse.isEmpty()) {
            return new ResponseEntity<>(orderResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
