package com.example.ordermanagementsystemapi.repository;

import com.example.ordermanagementsystemapi.model.dao.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    @Modifying
    @Query("UPDATE OrderLine ol SET ol.quantity = :newQuantity WHERE ol.id = :orderLineId")
    Integer findOrderLineByIdAndUpdateQuantity(@Param("orderLineId") Long orderLineId, @Param("newQuantity") int newQuantity);
}

