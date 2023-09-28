package com.example.ordermanagementsystemapi.repository;

import com.example.ordermanagementsystemapi.model.dao.Customer;
import com.example.ordermanagementsystemapi.model.dao.Order;
import com.example.ordermanagementsystemapi.model.dao.OrderLine;
import com.example.ordermanagementsystemapi.model.dao.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepositoryImpl implements CustomOrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> customSearch(String customerEmail, Long skuCode, Date date) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root<Order> root = query.from(Order.class);
        List<Predicate> predicates = new ArrayList<>();
        if (customerEmail != null) {
            Join<Order, Customer> customerJoin = root.join("customer");
            predicates.add(builder.equal(customerJoin.get("email"), customerEmail));
        }
        if (skuCode != null) {
            Join<Order, OrderLine> orderLineJoin = root.join("orderLines");
            Join<OrderLine, Product> productJoin = orderLineJoin.join("product");
            predicates.add(builder.equal(productJoin.get("skuCode"), skuCode));
        }
        if (date != null) {
            predicates.add(builder.equal(root.get("submissionDate"), date));
        }
        query.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Order> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
