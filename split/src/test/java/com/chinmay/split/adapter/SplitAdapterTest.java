package com.chinmay.split.adapter;

import com.chinmay.split.model.request.*;
import com.chinmay.split.model.response.BaseResponse;
import com.chinmay.split.shared.entity.*;
import com.chinmay.split.shared.repositories.ExpenseJpaRepo;
import com.chinmay.split.shared.repositories.ExpenseSplitJpa;
import com.chinmay.split.shared.repositories.GroupJpaRepo;
import com.chinmay.split.shared.repositories.UserJpaRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Add this annotation
class SplitAdapterTest {

    @Mock
    private GroupJpaRepo gr;

    @Mock
    private UserJpaRepo uj;

    @Mock
    private ExpenseSplitJpa esp;

    @Mock
    private ExpenseJpaRepo ej;

    @InjectMocks
    private SplitAdapter splitAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        CreateUserReq req = new CreateUserReq();
        req.setfName("John");
        req.setlName("Doe");

        ResponseEntity<BaseResponse> response = splitAdapter.createUser(req);

        assertEquals("200", response.getBody().getStatusCode());
        assertEquals("Success", response.getBody().getStatus());
        verify(uj, times(1)).save(any(User_table.class));
    }

    @Test
    void testCreateGroup() {
        CreateGroupReq req = new CreateGroupReq();
        req.setHostId(1);
        req.setGroupName("Test Group");
        List<Integer> userIds = new ArrayList<>();
        userIds.add(2);
        userIds.add(3);
        req.setUserIds(userIds);

        ResponseEntity<BaseResponse> response = splitAdapter.createGroup(req);

        assertEquals("200", response.getBody().getStatusCode());
        assertEquals("Success", response.getBody().getStatus());
        verify(gr, times(1)).saveAll(anyList());
    }

    @Test
    void testCreateExpense() {
        CreateExpenseReq req = new CreateExpenseReq();
        req.setExpenseName("Dinner");
        req.setHostId(1);
        req.setTotalAmount(100);
        req.setGroupId("GP123");

        List<Groups_table> groupList = new ArrayList<>();
        Groups_table group1 = new Groups_table();
        group1.setGroup_id("GP123");
        group1.setUserId(2);
        group1.setHostId(1);
        groupList.add(group1);

        when(gr.getGroupById(anyString())).thenReturn(groupList);

        Expense_split_table mockExpenseSplit = new Expense_split_table();
        mockExpenseSplit.setAmountToBePaid(50); // Set a valid amount for the mock object

        when(esp.getHostOwesMoneyRecord(anyString(), anyString(), anyInt(), anyInt())).thenReturn(mockExpenseSplit);

        ResponseEntity<BaseResponse> response = splitAdapter.createExpense(req);

        assertEquals("200", response.getBody().getStatusCode());
        assertEquals("Success", response.getBody().getStatus());
        verify(esp, times(1)).saveAll(anyList());
        verify(ej, times(1)).save(any(Expense_table.class));
    }

    @Test
    void testUpdatePayment() {
        SettlePaymentReq req = new SettlePaymentReq();
        req.setGroupId("GP123");
        req.setExpenseId("EX123");
        req.setPayeeId(2);
        req.setHostId(1);
        req.setAmount(50);

        Expense_split_table expenseSplit = new Expense_split_table();
        expenseSplit.setAmountToBePaid(100);

        when(esp.getHostOwesMoneyRecord(anyString(), anyString(), anyInt(), anyInt())).thenReturn(expenseSplit);
        when(ej.findByExpenseId(anyString())).thenReturn(new Expense_table());

        ResponseEntity<BaseResponse> response = splitAdapter.updatePayment(req);

        assertEquals("200", response.getBody().getStatusCode());
        assertEquals("Success", response.getBody().getStatus());
        verify(esp, times(1)).save(any(Expense_split_table.class));
        verify(ej, times(1)).save(any(Expense_table.class));
    }
}