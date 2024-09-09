package com.chinmay.split.port;

import com.chinmay.split.model.request.CreateExpenseReq;
import com.chinmay.split.model.request.CreateGroupReq;
import com.chinmay.split.model.request.CreateUserReq;
import com.chinmay.split.model.request.OwesRequest;
import com.chinmay.split.model.response.BaseResponse;
import com.chinmay.split.model.response.OwesListFinalResp;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SplitPort {

    public ResponseEntity<BaseResponse> createUser(CreateUserReq req);

    public ResponseEntity<BaseResponse> createGroup(CreateGroupReq req);

    public ResponseEntity<BaseResponse> createExpense(CreateExpenseReq req);

    ResponseEntity<OwesListFinalResp> getOwesList(OwesRequest req,int id);


}
