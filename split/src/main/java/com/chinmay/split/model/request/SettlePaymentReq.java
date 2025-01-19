package com.chinmay.split.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettlePaymentReq {

    @JsonProperty("groupId")
    private String groupId;

    @JsonProperty("expenseId")
    private String expenseId;

    @JsonProperty("payeeId")
    private int payeeId;

    @JsonProperty("hostId")
    private int hostId;

    @JsonProperty("amount")
    private double amount;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
