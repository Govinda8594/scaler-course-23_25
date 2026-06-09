package com.scaler.DesignPattern.structural.Facade;

public class ClientApp {
    static void main() {
        AmazonFacade amazonFacade = new AmazonFacade();
        amazonFacade.confirmOrder();
    }
}
