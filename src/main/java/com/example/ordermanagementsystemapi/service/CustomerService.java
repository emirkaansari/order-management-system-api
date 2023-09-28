package com.example.ordermanagementsystemapi.service;

import com.example.ordermanagementsystemapi.model.dao.Customer;
import com.example.ordermanagementsystemapi.model.dto.request.CreateCustomerRequest;
import com.example.ordermanagementsystemapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void createCustomer(CreateCustomerRequest createCustomerRequest) {
        customerRepository.save(Customer.builder()
                .fullName(createCustomerRequest.getFullName())
                .email(createCustomerRequest.getEmail())
                .telephone(createCustomerRequest.getTelephone())
                .build());
    }

    public boolean doesCustomerExist(String email) {
        return customerRepository.existsByEmail(email);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email).orElse(null);
    }
}
