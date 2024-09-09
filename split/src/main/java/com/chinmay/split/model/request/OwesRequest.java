package com.chinmay.split.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwesRequest {


    @Override
    public String toString() {
        return "OwesRequest{" +
                "userId=" + userId +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }

    @JsonProperty("userId")
    int userId;

    @JsonProperty("pageNumber")
    int pageNumber;

    @JsonProperty("pageSize")
    int pageSize;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
