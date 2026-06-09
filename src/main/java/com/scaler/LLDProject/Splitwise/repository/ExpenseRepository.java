package com.scaler.LLDProject.Splitwise.repository;

import com.scaler.LLDProject.Splitwise.models.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {
    private List<Expense> expenses;

    public ExpenseRepository() {
        this.expenses = new ArrayList<Expense>();
    }

    public void addExp(Expense expense) {
        expenses.add(expense);
    }
}
