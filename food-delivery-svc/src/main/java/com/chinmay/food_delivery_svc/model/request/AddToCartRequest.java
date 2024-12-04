package com.chinmay.food_delivery_svc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddToCartRequest {

    @JsonProperty("customerId")
    int customerId;

    @JsonProperty("restaurantAndOrder")
    List<RestaurantAndOrder> resOrder;

    public AddToCartRequest(int customerId, List<RestaurantAndOrder> resOrder) {
        this.customerId = customerId;
        this.resOrder = resOrder;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<RestaurantAndOrder> getResOrder() {
        return resOrder;
    }

    public void setResOrder(List<RestaurantAndOrder> resOrder) {
        this.resOrder = resOrder;
    }
}
