package com.example.ordermanagementsystemapi.repository;

import com.example.ordermanagementsystemapi.model.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    boolean existsByEmail(String email);

    Optional<Customer> findCustomerByEmail(String email);
}
