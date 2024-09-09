package com.chinmay.split.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserReq {
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    private String fName;
    private String lName;
}
