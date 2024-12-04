package com.chinmay.food_delivery_svc.adapter;

import com.chinmay.food_delivery_svc.model.request.ProcessPayment;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;
import com.chinmay.food_delivery_svc.port.PaymentStrategyPort;
import com.chinmay.food_delivery_svc.shared.repository.OrdersJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentStrategyAdapter implements PaymentStrategyPort {

    @Autowired
    OrdersJpaRepo orderRepo;





    @Override
    public BaseResponse processPayment(String orderId, ProcessPayment paymentRequest) {

        BaseResponse response = new BaseResponse();
        BaseResponse resp = new BaseResponse();

        orderRepo.updateOrderById(orderId,"COMPLETED");

        resp.setStatusDesc("Success");
        resp.setStatusMsg("Success");
        resp.setStatusCode(200);
        return resp;
    }
}
