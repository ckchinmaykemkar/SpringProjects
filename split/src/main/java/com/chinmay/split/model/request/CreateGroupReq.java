package com.chinmay.split.model.request;

import com.chinmay.split.shared.entity.User_table;

import java.util.ArrayList;
import java.util.List;

public class CreateGroupReq {


    private int hostId;
    private List<Integer> userIds = new ArrayList<>();

    private String groupName;

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public int getHostId() {
        return hostId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
