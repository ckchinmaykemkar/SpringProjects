package com.chinmay.split.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwesList {
    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "OwesList{" +
                "userName='" + userName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("amount")
    private double amount;
}
