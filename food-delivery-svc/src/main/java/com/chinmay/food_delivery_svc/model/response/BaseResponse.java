package com.chinmay.food_delivery_svc.model.response;

public class BaseResponse {

    int statusCode;
    String statusDesc;
    String statusMsg;

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "statusCode=" + statusCode +
                ", statusDesc='" + statusDesc + '\'' +
                ", statusMsg='" + statusMsg + '\'' +
                '}';
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
