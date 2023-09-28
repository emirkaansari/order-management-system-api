package com.example.ordermanagementsystemapi.repository;

import com.example.ordermanagementsystemapi.model.dao.Order;

import java.util.Date;
import java.util.List;

public interface CustomOrderRepository {
    List<Order> customSearch(String email, Long skuCode, Date date);
}
