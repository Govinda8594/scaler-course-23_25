package com.scaler.DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon { // publisher -> where the event actually happens
    private static Amazon instance;
    private List<OrderPlacedSubscriber> orderPlacedSubscribers;

    public Amazon() {
        this.orderPlacedSubscribers = new ArrayList<>();
    }

    public static Amazon getInstance() { //TODO : make this thread safe
        if (instance == null) {
            instance = new Amazon();
        }
        return instance;
    }

    public void orderPlaced() { //event method
//        CustomerNotifier customerNotifier = new CustomerNotifier();
//        customerNotifier.orderPlaceEvent();
//
//        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
//        invoiceGenerator.orderPlaceEvent();
        for (OrderPlacedSubscriber orderPlacedSubscriber : orderPlacedSubscribers) {
            orderPlacedSubscriber.announceOrderPlacement();
        }
    }

    public void registerOrderPlacedSubscriber(OrderPlacedSubscriber orderPlacedSubscriber) {
        orderPlacedSubscribers.add(orderPlacedSubscriber);
    }

    public void deRegisterOrderPlacedSubscriber(OrderPlacedSubscriber orderPlacedSubscriber) {
        orderPlacedSubscribers.remove(orderPlacedSubscriber);
    }

}
