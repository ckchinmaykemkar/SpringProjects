package com.chinmay.food_delivery_svc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAndOrder {

    @JsonProperty("restaurantId")
    String restaurantId;

    @JsonProperty("foodItems")
    List<FoodItems> foodItems = new ArrayList<>();

    public RestaurantAndOrder(String restaurantId, List<FoodItems> foodItems) {
        this.restaurantId = restaurantId;
        this.foodItems = foodItems;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<FoodItems> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItems> foodItems) {
        this.foodItems = foodItems;
    }
}
