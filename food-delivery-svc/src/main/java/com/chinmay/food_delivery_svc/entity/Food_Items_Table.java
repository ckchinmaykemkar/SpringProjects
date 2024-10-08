package com.chinmay.food_delivery_svc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Food_Items_Table")
public class Food_Items_Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

   @ManyToOne
   @JoinColumn(name = "restaurantId")
   Restaurant restaurant;

   @Column(name="category")
   String category;

   @Column(name="item_name")
   String item_name;

   @Column(name="status")
   String available;

   @Column(name="price")
   double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
