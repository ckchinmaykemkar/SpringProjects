package com.chinmay.split.adapter;

import com.chinmay.split.exception.SplitException;
import com.chinmay.split.model.request.CreateExpenseReq;
import com.chinmay.split.model.request.CreateGroupReq;
import com.chinmay.split.model.request.CreateUserReq;
import com.chinmay.split.model.request.OwesRequest;
import com.chinmay.split.model.response.BaseResponse;
import com.chinmay.split.model.response.OwesList;
import com.chinmay.split.model.response.OwesListFinalResp;
import com.chinmay.split.port.SplitPort;
import com.chinmay.split.shared.entity.*;
import com.chinmay.split.shared.repositories.ExpenseJpaRepo;
import com.chinmay.split.shared.repositories.ExpenseSplitJpa;
import com.chinmay.split.shared.repositories.GroupJpaRepo;
import com.chinmay.split.shared.repositories.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SplitAdapter implements SplitPort {


    @Autowired
    GroupJpaRepo gr;

    @Autowired
    UserJpaRepo uj;

    @Autowired
    ExpenseSplitJpa esp;

    @Autowired
    ExpenseJpaRepo ej;

    @Override
    public ResponseEntity<BaseResponse> createUser(CreateUserReq req) {

        BaseResponse res = new BaseResponse();

        try{
            User_table user = new User_table();
            user.setFirstName(req.getfName());
            user.setLastName(req.getlName());
            uj.save(user);

            res.setStatusDesc("Success");
            res.setStatus("Success");
            res.setStatusCode("200");

        }catch (Exception ex){
            ex.printStackTrace();
            res.setStatus("Error");
            res.setStatusCode("500");
            res.setStatusDesc(ex.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> createGroup(CreateGroupReq req) {

        BaseResponse res = new BaseResponse();
        String grpId = generatePlaylistId("GP");

        try{

            List<Groups_table> groupsList = req.getUserIds().stream()
                    .map(userId -> {
                        Groups_table group = new Groups_table();
                        group.setGroup_id(grpId);
                        group.setGroupName(req.getGroupName());
                        group.setHostId(req.getHostId());
                        group.setUserId(userId);
                        return group;
                    })
                    .collect(Collectors.toList());

            gr.saveAll(groupsList);

            res.setStatusDesc("Success");
            res.setStatus("Success");
            res.setStatusCode("200");

        }catch (Exception ex){
            ex.printStackTrace();
            res.setStatus("Error");
            res.setStatusCode("500");
            res.setStatusDesc(ex.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> createExpense(CreateExpenseReq req) {
        BaseResponse res = new BaseResponse();
        try {

            List<Groups_table> groupList = gr.getGroupById(req.getGroupId());
            String expenseId = generatePlaylistId("EX");
            int totalMembers = groupList.size()+1;
            double amountToBePaid = (double) req.getTotalAmount() / totalMembers;

            List<Expense_split_table> expense_List= groupList.stream().map(
                    group->{
                        Expense_split_table est= new Expense_split_table();
                        est.setExpenseId(expenseId);
                        est.setGroupId(req.getGroupId());
                        est.setExpenseName(req.getExpenseName());
                        est.setAmountToBePaid(amountToBePaid);
                        est.setExpenseName(req.getExpenseName());
                        est.setHostId(req.getHostId());
                        if(req.getHostId() == group.getUserId()){
                            est.setPayeeId(group.getHostId());
                        }else{
                            est.setPayeeId(group.getUserId());
                        }
                        est.setPaymentStatus("PENDING");
                        return est;

                    }).toList();


            esp.saveAll(expense_List);

            Expense_table et = new Expense_table();
            int totalAmount = req.getTotalAmount() - (req.getTotalAmount() % totalMembers);
            et.setExpenseId(expenseId);
            et.setExpenseName(req.getExpenseName());
            et.setHostId(req.getHostId());
            et.setTotalAmount(totalAmount-amountToBePaid);
            et.setPaymentStatus("PENDING");
            ej.save(et);

            res.setStatusDesc("Success");
            res.setStatus("Success");
            res.setStatusCode("200");

        }catch (Exception ex){
            ex.printStackTrace();
            res.setStatus("Error");
            res.setStatusCode("500");
            res.setStatusDesc(ex.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);

        }



        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OwesListFinalResp> getOwesList(OwesRequest req,int id) {

        OwesListFinalResp res = new OwesListFinalResp();

        try {

            Pageable page = PageRequest.of(req.getPageNumber(),req.getPageSize());
            Page<ExpenseProjection> epList = esp.getPayeeRecords(id,page);
            List<OwesList> tempList = epList.stream().map(
                    users->{
                        OwesList ol = new OwesList();
                        ol.setAmount(users.getAmountToBePaid());
                        ol.setUserName(users.getFirstName());
                        return ol;
                    }
            ).collect(Collectors.toList());

            res.totalCount = epList.getTotalPages();
            res.owesListResp = tempList;
            res.setStatusDesc("Success");
            res.setStatus("Success");
            res.setStatusCode("200");

        }catch (Exception ex){
            ex.printStackTrace();
            res.setStatus("Error");
            res.setStatusCode("500");
            res.setStatusDesc(ex.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(res, HttpStatus.OK);


    }

    private String generatePlaylistId(String prefix) {
        return prefix + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
