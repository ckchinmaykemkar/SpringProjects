package com.chinmay.food_delivery_svc.adapter;

import com.chinmay.food_delivery_svc.entity.Restaurant;
import com.chinmay.food_delivery_svc.exception.FoodDeliveryException;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;
import com.chinmay.food_delivery_svc.port.FoodDeliveryPort;
import com.chinmay.food_delivery_svc.shared.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodDeliveryAdapter implements FoodDeliveryPort {

    @Autowired
    CustomerJpaRepo customerRepo;

    @Autowired
    DeliveryPartnerJpaRepo deliverAgentRepo;

    @Autowired
    FoodItemsJpaRepo foodItemRepo;

    @Autowired
    OrdersJpaRepo ordersJpaRepo;

    @Autowired
    RestaurantJpaRepo restaurantJpaRepo;

    @Autowired
    ShoppingCartJpaRepo shoppingRepo;


    @Override
    public BaseResponse saveRestaurantsAndFoodItems(Restaurant restaurant) {

        BaseResponse response = new BaseResponse();
        try {
            restaurantJpaRepo.save(restaurant);
            response.setStatusCode(200);
            response.setStatusDesc("Success");
            response.setStatusMsg("Success");
        }catch(FoodDeliveryException ex){
            ex.printStackTrace();
            response.setStatusCode(500);
            response.setStatusDesc("Error occurred");
            response.setStatusMsg("Error ocurred");
        }

       return response;

    }




}
