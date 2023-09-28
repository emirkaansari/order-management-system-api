package com.example.ordermanagementsystemapi.api;

import com.example.ordermanagementsystemapi.model.dto.request.CreateCustomerRequest;
import com.example.ordermanagementsystemapi.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        if (customerService.doesCustomerExist(createCustomerRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer already exists.");
        }
        customerService.createCustomer(createCustomerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully.");
    }
}
