package com.chinmay.split.shared.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Expense_split_table")
public class Expense_split_table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "expenseId")
    private String expenseId;

    @Column(name = "expenseName")
    private String expenseName;

    @Column(name = "hostId")
    private int hostId;


    @Column(name = "groupName")
    private String groupName;


    @Column(name = "groupId")
    private String groupId;


    @Column(name = "payeeId")
    private int payeeId;

    @Column(name="amountToBePaid")
    private double amountToBePaid;

    public String getPaymentStatus() {
        return paymentStatus;
    }


    @Column(name="paymentStatus")
    private String paymentStatus;

    public String getGroupId() {
        return groupId;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public double getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(double amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }



    @Column(name = "creationDate")
    private LocalDate creationDate = LocalDate.now();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}



