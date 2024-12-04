package com.chinmay.food_delivery_svc.shared.repository;

import com.chinmay.food_delivery_svc.entity.Orders_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrdersJpaRepo extends JpaRepository<Orders_table,Long> {


    @Modifying
    @Query(value = "update Orders_table ot set ot.paymentStatus = ?2 where ot.orderId = ?1")
    public int updateOrderById(String orderId,String status);
}
