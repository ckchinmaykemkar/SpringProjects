package com.chinmay.food_delivery_svc.shared.repository;

import com.chinmay.food_delivery_svc.entity.Delivery_partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DeliveryPartnerJpaRepo extends JpaRepository<Delivery_partner,Long> {
}
