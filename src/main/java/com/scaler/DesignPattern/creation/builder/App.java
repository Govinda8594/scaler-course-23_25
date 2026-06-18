package com.scaler.DesignPattern.creation.builder;

public class App {


    public static void main(String[] args) {

        Student studentSheela = Student.getBuilder()
                .setBatch("April")
                .setName("Sheela")
                .setPsp(93)
                .build();


        Student studentShubhadeep = Student.getBuilder()
                .setName("Shubhadeep")
                .setBatch("May")
                .build();


    }
}
