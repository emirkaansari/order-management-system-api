package com.example.ordermanagementsystemapi.repository;

import com.example.ordermanagementsystemapi.model.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
