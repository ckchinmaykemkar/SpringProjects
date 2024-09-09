package com.chinmay.split.controller;

import com.chinmay.split.model.request.CreateExpenseReq;
import com.chinmay.split.model.request.CreateGroupReq;
import com.chinmay.split.model.request.CreateUserReq;
import com.chinmay.split.model.request.OwesRequest;
import com.chinmay.split.model.response.BaseResponse;
import com.chinmay.split.model.response.OwesListFinalResp;
import com.chinmay.split.port.SplitPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SplitWIseController {

    @Autowired
    SplitPort port;


    @PostMapping(value = "/createUser")
    public ResponseEntity<BaseResponse> createUser(@RequestBody CreateUserReq req){
        return port.createUser(req);
    }


    @PostMapping(value = "/createGroup")
    public ResponseEntity<BaseResponse> createGroup(@RequestBody CreateGroupReq req){
        return port.createGroup(req);
    }

    @PostMapping(value = "/createExpense")
    public ResponseEntity<BaseResponse> createExpense(@RequestBody CreateExpenseReq req){
        return port.createExpense(req);
    }

    @GetMapping(value = "/getOwesList/{id}")
    public ResponseEntity<OwesListFinalResp> getOwesList(@RequestBody OwesRequest req, @PathVariable("id") int id){
        return port.getOwesList(req,id);
    }
}
