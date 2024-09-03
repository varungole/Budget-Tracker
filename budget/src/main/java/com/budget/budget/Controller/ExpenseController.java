package com.budget.budget.Controller;


import com.budget.budget.Entity.Expense;
import com.budget.budget.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/expense/v2")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getExpense() {
        return expenseService.getExpense();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable("id") Integer id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@RequestBody Expense expense, @PathVariable("id") Integer id) {
        return expenseService.updateExpense(expense, id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/top")
    public List<Expense> getTopExxpense() {
        return expenseService.showTopExpenses();
    }




}
