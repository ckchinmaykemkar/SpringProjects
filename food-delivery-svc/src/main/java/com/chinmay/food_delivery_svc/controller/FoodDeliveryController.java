package com.chinmay.food_delivery_svc.controller;


import com.chinmay.food_delivery_svc.adapter.BankPaymentStrategy;
import com.chinmay.food_delivery_svc.adapter.CardPaymentStrategyAdapter;
import com.chinmay.food_delivery_svc.entity.Restaurant;
import com.chinmay.food_delivery_svc.model.request.AddToCartRequest;
import com.chinmay.food_delivery_svc.model.request.PlaceOrderReq;
import com.chinmay.food_delivery_svc.model.request.ProcessPayment;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;
import com.chinmay.food_delivery_svc.port.FoodDeliveryPort;
import com.chinmay.food_delivery_svc.port.PaymentStrategyPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FoodDeliveryController {

    @Autowired
    FoodDeliveryPort port;

    static Map<String, PaymentStrategyPort> payMap=new HashMap<String,PaymentStrategyPort>();

    static{
      payMap.put("card",new CardPaymentStrategyAdapter());
      payMap.put("bank",new BankPaymentStrategy());
    }

    @PostMapping(value = "/saveRestaurants")
    public BaseResponse saveRestaurants(@RequestBody Restaurant req){
        return port.saveRestaurantsAndFoodItems(req);
    }

    @PostMapping(value = "/saveShoppingCart")
    public BaseResponse saveRestaurants(@RequestBody AddToCartRequest req){
        return port.saveShoppingCart(req);
    }

    @PostMapping(value = "/initiatePayment")
    public BaseResponse initiatePayment(@RequestBody ProcessPayment req){


        return payMap.get(req.getPaymentType()).processPayment(req.getCartId(),req);
    }


    @PostMapping(value = "/placeOrder")
    public BaseResponse placeOrder(@RequestBody PlaceOrderReq req){
        return port.placeOrder(req);
    }



}
