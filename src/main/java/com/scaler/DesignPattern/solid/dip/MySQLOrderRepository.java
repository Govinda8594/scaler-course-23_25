package com.scaler.DesignPattern.solid.dip;

// Bad Example
class MySQLOrderRepository {

    public void saveOrder(String order) {
        System.out.println("Order saved in MySQL database: " + order);
    }
}

class OrderService {

    private MySQLOrderRepository repository;

    public OrderService(){
    }

    public void placeOrder(String order) {
        repository.saveOrder(order);
    }
}

// Good Example

interface OrderRepository {
    void saveOrder(String order);
}

class MySQLOrderRepository1 implements OrderRepository {

    @Override
    public void saveOrder(String order) {
        System.out.println("Order saved in MySQL database: " + order);
    }
}

class MongoOrderRepository implements OrderRepository {

    @Override
    public void saveOrder(String order) {
        System.out.println("Order saved in MongoDB: " + order);
    }
}

class OrderService1 {

    private OrderRepository repository;

    public OrderService1(OrderRepository repository) {
        this.repository = repository;
    }

    public void placeOrder(String order) {
        repository.saveOrder(order);
    }
}
 class Main {
    public static void main(String[] args) {

        OrderRepository repository = new MySQLOrderRepository1();
        OrderRepository repository2 = new MongoOrderRepository();
        OrderService1 service = new OrderService1(repository2);
        OrderService1 service2 = new OrderService1(repository);

        service.placeOrder("Laptop Order");
    }
}
