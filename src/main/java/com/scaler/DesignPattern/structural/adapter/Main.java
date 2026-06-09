package com.scaler.DesignPattern.structural.adapter;

public class Main {
    static void main() {
        PhonePe ph = new PhonePe(new ICICIBankAdapter());
        ph.showBalance();
    }
}
