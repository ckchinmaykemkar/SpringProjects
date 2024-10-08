package com.chinmay.food_delivery_svc.shared.repository;

import com.chinmay.food_delivery_svc.entity.Food_Items_Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FoodItemsJpaRepo extends JpaRepository<Food_Items_Table,Long> {
}
