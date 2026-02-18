package com.scaler.LLDProject.Splitwise.repository;

import com.scaler.LLDProject.Splitwise.models.UserExpense;

import java.util.ArrayList;
import java.util.List;

public class UserExpenseRepository {
    private List<UserExpense> expenseList;

    public UserExpenseRepository() {
        this.expenseList = new ArrayList<>();
    }

    public void addUserExpense(UserExpense expense) {
        expenseList.add(expense);
    }

    public List<UserExpense> findExpenseByUserExpense(String description) {
        ArrayList<UserExpense> expenses = new ArrayList<>();
        for (UserExpense expense : expenseList) {
            if (expense.getExpense().getDescription().equals(description)) {
                expenses.add(expense);
            }
        }
        return expenses;
    }
}
