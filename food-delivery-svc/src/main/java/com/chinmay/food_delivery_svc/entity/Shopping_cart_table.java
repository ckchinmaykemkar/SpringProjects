package com.chinmay.food_delivery_svc.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Shopping_cart_table")
public class Shopping_cart_table {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name="shopping_cart_id")
    String shopping_cart_id;

    @Column(name="customerId")
    int customerId;

    @Column(name="restaurantId")
    String restaurantId;

    @Column(name="foodItemName")
    String foodItemName;

    @Column(name="quantity")
    int quantity;

    @Column(name="price")
    double price;

    @Column(name="creation_date")
    @Temporal(value = TemporalType.DATE)
    Date creationDate;

    @Column(name = "isOrderPlaced")
    String isOrderPlaced;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(String shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getIsOrderPlaced() {
        return isOrderPlaced;
    }

    public void setIsOrderPlaced(String isOrderPlaced) {
        this.isOrderPlaced = isOrderPlaced;
    }
}
