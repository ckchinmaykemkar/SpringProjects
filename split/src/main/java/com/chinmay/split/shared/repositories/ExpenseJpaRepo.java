package com.chinmay.split.shared.repositories;

import com.chinmay.split.shared.entity.Expense_table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ExpenseJpaRepo extends JpaRepository<Expense_table,Long> {

    @Query("select e from Expense_table e where e.expenseId =?1")
    public Expense_table findByExpenseId(String expenseId);
}
