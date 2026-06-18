package com.scaler.DesignPattern.solid.srp;

//Bad Example

class Invoice_1 {
    public void calculateTotal() {}
    public void printInvoice() {}
    public void saveToDatabase() {}
}

// Good Example
class Invoice {
    public void calculateTotal() {}
}

class InvoicePrinter {
    public void print(Invoice invoice) {}
}

class InvoiceRepository {
    public void save(Invoice invoice) {}
}