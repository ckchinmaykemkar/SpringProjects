package com.chinmay.food_delivery_svc.controller;


import com.chinmay.food_delivery_svc.entity.Restaurant;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;
import com.chinmay.food_delivery_svc.port.FoodDeliveryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodDeliveryController {

    @Autowired
    FoodDeliveryPort port;

    @PostMapping(value = "/saveRestaurants")
    public BaseResponse saveRestaurants(@RequestBody Restaurant req){
        return port.saveRestaurantsAndFoodItems(req);
    }
}
