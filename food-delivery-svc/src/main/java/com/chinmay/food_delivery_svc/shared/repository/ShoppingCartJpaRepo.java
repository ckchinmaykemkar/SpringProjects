package com.chinmay.food_delivery_svc.shared.repository;

import com.chinmay.food_delivery_svc.entity.Shopping_cart_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ShoppingCartJpaRepo extends JpaRepository<Shopping_cart_table,Long> {

    @Query(value = "select st from Shopping_cart_table st where st.shopping_cart_id = ?1")
    public List<Shopping_cart_table> findByShoppingCartId(String id);


    @Modifying
    @Query(value = "update Shopping_cart_table st set st.isOrderPlaced =?3 where st.customerId=?1 and st.shopping_cart_id =?2")
    public int updateOrderStatusByCartIdAndCustId(int customerId, String cartId,String status);
}
