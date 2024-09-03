package com.budget.budget.Service;

import com.budget.budget.Entity.Expense;
import com.budget.budget.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpense() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Integer id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense updateExpense(Expense expense, Integer id) {
        expense.setId(id);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }

    public List<Expense> showTopExpenses() {
        List<Expense> list = expenseRepository.findAll();

        list.sort((Expense e1, Expense e2) -> {
            Float v1 = e1.getExpenseValue() != null ?  e1.getExpenseValue() : 0;
            Float v2 = e2.getExpenseValue() != null ? e2.getExpenseValue() : 0;
            return Float.compare(v2, v1);

        });
        return list;
    }
}
