package com.chinmay.moviesvc.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private String statusCode;
    private String statusDesc;
    private String statusMsg;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
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

    @Override
    public String toString() {
        return "BaseResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", statusMsg='" + statusMsg + '\'' +
                '}';
    }
}
