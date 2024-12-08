package com.chinmay.food_delivery_svc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodItems {

    @JsonProperty("foodName")
    String foodName;

    @JsonProperty("quantity")
    int quantity;

    @JsonProperty("price")
    Double price;

    public FoodItems(String foodName, int quantity, Double price) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
