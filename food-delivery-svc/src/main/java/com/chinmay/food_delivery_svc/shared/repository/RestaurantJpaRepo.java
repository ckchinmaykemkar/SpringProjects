package com.chinmay.food_delivery_svc.shared.repository;

import com.chinmay.food_delivery_svc.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RestaurantJpaRepo extends JpaRepository<Restaurant,Long> {
}
