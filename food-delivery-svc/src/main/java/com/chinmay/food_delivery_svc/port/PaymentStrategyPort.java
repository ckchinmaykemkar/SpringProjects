package com.chinmay.food_delivery_svc.port;

import com.chinmay.food_delivery_svc.model.request.ProcessPayment;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;

public interface PaymentStrategyPort {

    public BaseResponse processPayment(String cartId, ProcessPayment paymentRequest);
}
