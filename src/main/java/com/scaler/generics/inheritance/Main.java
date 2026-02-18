package com.scaler.generics.inheritance;

public class Main {

    public static void main(String[] args) {


        /*
          Extending inside generics
         */
        Walker<Dog> dogWalker = new Walker<>();
        Walker<Cat> catWalker = new Walker<>();

        Walker<Mammal> mammalWalker = new Walker<>();

//        Walker<Animal> AnimalWalker = new Walker<>();

//        Walker<Fish> fishWalker = new Walker<Fish>();

        /*

         */

        Animal Animal = new Dog();

        Animal.eat();

        Dog dog = new Dog();
        dog.run();
        Cat cat = new Cat();

        dog.eat();
        cat.eat();


    }

    public void something(Animal animal) {
        animal.eat();
    }
}
