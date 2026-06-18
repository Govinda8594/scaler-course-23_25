package com.scaler.DesignPattern.creation.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Employee prototypeEmployee =
                new Employee("Default Name", "Engineering", "ABC Company");

        Employee emp1 = prototypeEmployee.clone();
        emp1.setName("Govinda");

        Employee emp2 = prototypeEmployee.clone();
        emp2.setName("Rahul");

        emp1.showDetails();
        emp2.showDetails();
    }
}