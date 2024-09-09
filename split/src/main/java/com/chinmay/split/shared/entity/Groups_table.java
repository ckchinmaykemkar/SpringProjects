package com.chinmay.split.shared.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Groups_table")
public class Groups_table {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="group_id")
    private String group_id;

    @Column(name = "group_name")
    private String groupName;


    @Column(name="hostId")
    private int hostId;


    @Column(name="userId")
    private int userId;

    @Column(name="creationDate")
    private LocalDate creationDate = LocalDate.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
