package com.scaler.LLDProject.Splitwise.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> userList;
    private List<Expense> expenseList;

    public Group(String name) {
        this.name = name;
        this.userList = new ArrayList<>();
        this.expenseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
