package com.scaler.DesignPattern.structural.Facade;

// a DP where class which is responsible for calling multiple services.
public class AmazonFacade {
    private InventoryService inventoryService;
    private NotifyCustomerService notifyCustomerService;
    private  NotifyLogisticService notifyLogisticService;
    private  NotifySellerService notifySellerService;

    void confirmOrder() {
        inventoryService.updateInventory();
        notifyCustomerService.sendEmail();
        notifyCustomerService.sendSMS();
        notifyLogisticService.notifyLogistics();
        notifySellerService.notifySeller();
    }
}
