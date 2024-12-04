package com.chinmay.food_delivery_svc.port;

import com.chinmay.food_delivery_svc.entity.Restaurant;
import com.chinmay.food_delivery_svc.model.request.AddToCartRequest;
import com.chinmay.food_delivery_svc.model.request.PlaceOrderReq;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;

public interface FoodDeliveryPort {

    public BaseResponse saveRestaurantsAndFoodItems(Restaurant restaurant);

    public BaseResponse saveShoppingCart(AddToCartRequest request);

    public BaseResponse placeOrder(PlaceOrderReq req);
}
