package com.chinmay.food_delivery_svc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceOrderReq {

    @JsonProperty("customerId")
    int customerId;

    @JsonProperty("cartId")
    String cartId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
