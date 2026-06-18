package com.scaler.DesignPattern.creation.prototype;

//Prototype Design Pattern — Best Easy Example
//What is Prototype Pattern?
//Prototype is a Creational Design Pattern.
//It is used when we want to create a new object by copying an existing object, instead of creating it from scratch using new.
//Simple meaning:
//
//Prototype means: create a new object by cloning an existing object.
//
//
//Real-Life Example
//Imagine you are creating an employee record.
//Most employees may have common default values:
//
//Company name
//Department
//Office location
//Employee type
//
//Instead of creating every employee object from zero, we can create one sample employee object and clone it.
class Employee implements Cloneable {

    private String name;
    private String department;
    private String company;

    private Address address;


    public Employee(String name, String department, String company) {
        this.name = name;
        this.department = department;
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Company: " + company);
        System.out.println("---------------------");
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.address = this.address.clone();
        return cloned;
    }
}