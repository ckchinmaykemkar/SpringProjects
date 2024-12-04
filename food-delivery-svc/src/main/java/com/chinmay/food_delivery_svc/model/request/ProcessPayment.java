package com.chinmay.food_delivery_svc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessPayment {

    @JsonProperty("customerId")
    int customerId;

    @JsonProperty("cartId")
    String cartId;

    @JsonProperty("paymentType")
    String paymentType;

    @JsonProperty("cardDtls")
    Card card;

    @JsonProperty("BandDetails")
    BankDetails bankDtls;

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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BankDetails getBankDtls() {
        return bankDtls;
    }

    public void setBankDtls(BankDetails bankDtls) {
        this.bankDtls = bankDtls;
    }
}


class Card{
    @JsonProperty("cardNumber")
    String cardNumber;

    @JsonProperty("cvv")
    String cvv;

    @JsonProperty("expiryDate")
    String expiryDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public Card(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
}

class BankDetails{
    @JsonProperty("accountNumber")
    String accountNumber;

    @JsonProperty("ifsc")
    String ifsc;

    @JsonProperty("bankName")
    String bankName;

    public BankDetails(String accountNumber, String ifsc, String bankName) {
        this.accountNumber = accountNumber;
        this.ifsc = ifsc;
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getIfsc() {
        return ifsc;
    }

    public String getBankName() {
        return bankName;
    }
}
