package com.chinmay.split.shared.repositories;

import com.chinmay.split.shared.entity.ExpenseProjection;
import com.chinmay.split.shared.entity.Expense_split_table;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ExpenseSplitJpa extends JpaRepository<Expense_split_table,Long> {


    @Query(value = "select u.first_name as first_name , es.amountToBePaid as amountToBePaid from Expense_split_table es " +
            "inner join User_table u on u.id = es.payeeId where es.amountToBePaid > 0 and es.payeeId = ?1",nativeQuery = true)
    public Page<ExpenseProjection> getPayeeRecords(int payeeId, Pageable page);
}
