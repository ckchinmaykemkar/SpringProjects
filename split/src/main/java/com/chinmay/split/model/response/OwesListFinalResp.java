package com.chinmay.split.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OwesListFinalResp extends BaseResponse{

    @JsonProperty("owesListResp")
    public List<OwesList> owesListResp = new ArrayList<OwesList>();

    @JsonProperty("totalCount")
    public int totalCount;

    @Override
    public String toString() {
        return "OwesListFinalResp{" +
                "owesListResp=" + owesListResp +
                ", totalCount=" + totalCount +
                '}';
    }
}
