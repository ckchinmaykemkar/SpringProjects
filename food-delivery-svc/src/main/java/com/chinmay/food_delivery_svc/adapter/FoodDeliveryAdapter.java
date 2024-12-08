package com.chinmay.food_delivery_svc.adapter;

import com.chinmay.food_delivery_svc.entity.Orders_table;
import com.chinmay.food_delivery_svc.entity.Restaurant;
import com.chinmay.food_delivery_svc.entity.Shopping_cart_table;
import com.chinmay.food_delivery_svc.exception.FoodDeliveryException;
import com.chinmay.food_delivery_svc.model.request.AddToCartRequest;
import com.chinmay.food_delivery_svc.model.request.PlaceOrderReq;
import com.chinmay.food_delivery_svc.model.response.BaseResponse;
import com.chinmay.food_delivery_svc.port.FoodDeliveryPort;
import com.chinmay.food_delivery_svc.shared.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class FoodDeliveryAdapter implements FoodDeliveryPort {

    @Autowired
    CustomerJpaRepo customerRepo;

    @Autowired
    DeliveryPartnerJpaRepo deliverAgentRepo;

    @Autowired
    FoodItemsJpaRepo foodItemRepo;

    @Autowired
    OrdersJpaRepo ordersJpaRepo;

    @Autowired
    RestaurantJpaRepo restaurantJpaRepo;

    @Autowired
    ShoppingCartJpaRepo shoppingRepo;

    @Autowired
    OrdersJpaRepo orderRepo;


    @Override
    public BaseResponse saveRestaurantsAndFoodItems(Restaurant restaurant) {

        BaseResponse response = new BaseResponse();
        try {
            restaurantJpaRepo.save(restaurant);
            response.setStatusCode(200);
            response.setStatusDesc("Success");
            response.setStatusMsg("Success");
        }catch(FoodDeliveryException ex){
            ex.printStackTrace();
            response.setStatusCode(500);
            response.setStatusDesc("Error occurred");
            response.setStatusMsg("Error ocurred");
        }

       return response;

    }

    @Override
    public BaseResponse saveShoppingCart(AddToCartRequest request) {
        BaseResponse response = new BaseResponse();

        try{
            //String shoppingId = generatePlaylistId("ZM");

            int custId = request.getCustomerId();
            String shoppingCartId = generatePlaylistId("SC");

            List<Shopping_cart_table> shoppingCartItems = request.getResOrder().stream()
                    .flatMap(it ->
                            it.getFoodItems().stream().map(i -> {
                                Shopping_cart_table sct = new Shopping_cart_table();
                                sct.setCustomerId(custId);
                                sct.setShopping_cart_id(shoppingCartId);
                                sct.setRestaurantId(it.getRestaurantId());
                                sct.setFoodItemName(i.getFoodName());
                                sct.setQuantity(i.getQuantity());
                                sct.setPrice(i.getQuantity() * i.getPrice());
                                sct.setCreationDate(LocalDate.now());
                                return sct;
                            })
                    )
                    .toList();

            shoppingRepo.saveAll(shoppingCartItems);
            response.setStatusMsg("Success");
            response.setStatusDesc("Success");
            response.setStatusCode(200);


        }catch (FoodDeliveryException ex){
            ex.printStackTrace();
            response.setStatusMsg("Error");
            response.setStatusDesc("Something went wrong!!");
            response.setStatusCode(500);
        }

        return response;
    }

    @Override
    public BaseResponse placeOrder(PlaceOrderReq req) {

        BaseResponse response = new BaseResponse();
        String orderId = generatePlaylistId("JP");

        try {

            List<Shopping_cart_table> cartItems = shoppingRepo.findByShoppingCartId(req.getCartId());
            Orders_table or = new Orders_table();
            or.setPaymentStatus("SUCCESSFULL");
            or.setOrderId(orderId);
            or.setOrderStatus("PLACED");
            or.setCustomer_id(req.getCustomerId());
            or.setShoppingCartId(req.getCartId());

            shoppingRepo.updateOrderStatusByCartIdAndCustId(req.getCustomerId(), req.getCartId(), "true");

            ordersJpaRepo.save(or);

            response.setStatusMsg("Success");
            response.setStatusDesc("Success");
            response.setStatusCode(200);
        }catch (FoodDeliveryException ex){
            ex.printStackTrace();
            response.setStatusMsg("Error");
            response.setStatusDesc("Something went wrong!!");
            response.setStatusCode(500);
        }

        return response;
    }

    private String generatePlaylistId(String prefix) {
        return prefix + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }




}
