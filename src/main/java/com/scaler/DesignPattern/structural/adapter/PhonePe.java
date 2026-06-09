package com.scaler.DesignPattern.structural.adapter;

class PhonePe {
    private final BankApi bankAPI; // Depends on abstraction, not concrete class

    PhonePe(BankApi api) {
        this.bankAPI = api;
    }

    void showBalance() {
        double balance = bankAPI.getBalance();
        System.out.println("Balance: " + balance);
    }
}