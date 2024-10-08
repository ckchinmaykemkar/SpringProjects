package com.chinmay.food_delivery_svc.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Restaurant_table")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name="restaurantId")
    String restaurantId;

    @Column(name="name")
    String name;

    @Column(name="stateCode")
    String stateCode;

    @Column(name="city")
    String city;

    @Column(name="lat")
    String lat;

    @Column(name="lng")
    String lng;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Food_Items_Table> foodItems;


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public List<Food_Items_Table> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<Food_Items_Table> foodItems) {
        this.foodItems = foodItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
