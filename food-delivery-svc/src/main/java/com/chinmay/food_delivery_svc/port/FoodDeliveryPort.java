package com.chinmay.food_delivery_svc.port;

import com.chinmay.food_delivery_svc.entity.Restaurant;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;

public interface FoodDeliveryPort {

    public BaseResponse saveRestaurantsAndFoodItems(Restaurant restaurant);
}
