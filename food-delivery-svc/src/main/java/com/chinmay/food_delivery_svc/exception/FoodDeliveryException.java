package com.chinmay.food_delivery_svc.exception;

public class FoodDeliveryException extends RuntimeException {

    int errCode;
    int errMsg;

    public FoodDeliveryException(int errCode,int errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
