package com.scaler.LLDProject.Splitwise.models;

public class Expense {
    private String description;
    private int amount;
    private ExpenseType type;

    public Expense(String description, int amount, ExpenseType type) {
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }
}
