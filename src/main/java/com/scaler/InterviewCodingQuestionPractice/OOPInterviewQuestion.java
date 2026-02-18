package com.scaler.InterviewCodingQuestionPractice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Predicate;

@FunctionalInterface
interface DemoInterface {

    void fun();
}


public class OOPInterviewQuestion {

    public static void main(String[] args) {
        // so compliation error will occur only either constructor
        // is created in parent or not and child class dont have a default constructor;
        Vehical v = new car("dhsjhf");
        v.speed();
        Vehical v2 = new Vehical("hjfj");
        v2.speed();
        // Airservice is abstract, cannot be instantiated.
//        AirService s = new AirService();

//        AirService.serviceplanNo("airservice");

        // while creating new instance of
        // AirService when call to default constructor method of child class no error in this line

        AirService s1 = new Indigo();
//        s1 holds indigo reference
//        register is concerte method
//        if overridden in child class then register get called in child mthod
//        if not overriden, otherwise it called partent class register method inheritance
        s1.register();  // not overridden by child then called partent register
        s1.typeofengine(); //  overriden by child so called child class

        Indigo indigo = new Indigo();
//        even object is created for indigo and refernce type is indigo,
//         then register is concrete method of abstract class  while calling register method noties child class dont
//         have register method so it will call parent register method
        indigo.register();
        indigo.typeofengine();

        //We can't create an object of interface.
        //Why ? Interfaces are incomplete.

        //Way 1 of creating object of interfaces.
        DemoClass way1 = new DemoClass();
        way1.fun();

        //Way 2 -> Anonymous class.
        DemoInterface way2 = new DemoInterface() {
            @Override
            public void fun() {
                System.out.println("Anonymous Class " +
                        "way of creating object of Interface");
            }
        };
        way2.fun();

        //Way 3 -> Lambda.
        DemoInterface way3 = () -> {
            //Provide the implementation of abstract method.
            System.out.println("Lambda way of DemoInterface");
        };
        way3.fun();

        //Anonymous Object
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.length() > 10) return true;
                else return false;
            }
        };
        System.out.println(predicate.test("Scaler"));
        System.out.println(predicate.test("Scaler School of Technology"));


        //Lambda
        // () -> Input parameters
        // {} -> Function implementation.
        Predicate<String> predicate1 = (str) -> str.length() > 10;
        //System.out.println(predicate1.test("Scaler School of Technology"));

        BiFunction<String, String, String> biFunction = (a, b) -> a + b;
        System.out.println(biFunction.apply("Hello ", "World!"));

        TreeSet<Integer> s = new TreeSet<>();
        s.addAll(List.of(10, 20, 5, 6, 7, 3, 4, 8));

        System.out.println("Treeset");
        //Safe - Iterator based code
        Iterator<Integer> tit = s.iterator();
        while (tit.hasNext()) {
            int element = tit.next();
            if (element == 5) {
                tit.remove();
            } else {
                System.out.println(element);
            }
        }
        //Throw Concurrent modification exception
        System.out.println("Treeset-2");
        for (Integer x : s) {
            if (x == 7) {
                s.remove(Integer.valueOf(x));
            }
            System.out.println(x);
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer sumOfNumbers = numbers.stream()
                .reduce(0, (sum, ele) -> {
                    return sum + ele;
                });

        Integer max = numbers.stream()
                .reduce(Integer.MIN_VALUE, (currMax, ele) -> {
                    return Math.max(currMax, ele);
                });

        System.out.println("sumOfNumbers = " + sumOfNumbers);
        System.out.println("max = " + max);
  /*
        USING STREAMS
         */

        Integer maxWithReduce = numbers.stream()
                .reduce(Integer.MIN_VALUE,
                        (curr_max, ele) -> Math.max(curr_max, ele));
    }


    static class Vehical {
        // this default constructor is necessary if child classes have default constructor
//    public Vehical(){
//    }

        public Vehical(String type) {
            System.out.println(type);
        }

        int speed() {
            System.out.println("Called from parent");
            return 0;
        }
    }

    static class car extends Vehical {
        public car(String type) {
            super(type);
        }
        // compilation error because in parent class we call to a default constructor of child class,
        // but we don't have default constructor in parent class.
        // so its always necessary to have a default constructor/parameterized
        // whenever we call to create object either passing value to constructor/parameterized constructor or default constructor

        //        car() {
//        }
        @Override
        int speed() {
            System.out.println("Called from parent");
            return 0;
        }
    }
}

abstract class AirService {
    // abstract class can have constructor
    AirService() {

    }

    // illegal method combination of modifiers abstract + static CT error
//    static abstract void serviceplanNo(String node) {
//        System.out.println(node);
//    }

    static void serviceplanNo() {
        System.out.println("inside static parent method");
    }

    // abstract class will be called abstract even when no abstract method is defined
//    abstract keyboard is mandatory for method if define
    abstract String typeofengine(); // Abstract method

    //  abstract class can have concrete methods as well as abstract methods
    void register() {
        System.out.println("Registering");
    }

    int getSpeed(String aeroname) {
        return 2;
    }

    //    synchronized + abstract // CT error
    abstract void airfuel(int lite);

}

// class should be declared abstract even if only one abstract method is defined
//class device{
//    abstract void readyTobeON();
//
//    // can have any number of default/concrete methods
//    void openScreen(){
//        System.out.println("Opening Screen");
//    }
//}

//class Organism{
//    // final variable need to be initialized, so either initialize with constructor or assign any value to it.
//    private final int lifeForce;// = Integer.MAX_VALUE;
////    public Organism(int lifeForce){
////        this.lifeForce = lifeForce;
////    }
//
//    private final int movementSpeed;
//
//    public Organism(int movementSpeed){
//        this.movementSpeed = movementSpeed;
//    }
//
//    // normal override will compile successfully for synchronization in subclass
//    public int getMovementSpeed()
//    {
//        return movementSpeed;
//    }
//}
//
//class Mammals extends Organism{
//
//
//    public Mammals() {
//        // parent don't have default constructor;
//        super(); //  parent class dont have constructor so CT error
//    }
//
//    // need parameterized constructor in parent class so CT error
//    public Mammals(int lifeForce, int movementSpeed) {
//        super(lifeForce, movementSpeed); //
//    }
//
//    @Override
//    public synchronized int getMovementSpeed() {
//        return super.getMovementSpeed();
//    }
//}

class Indigo extends AirService {


    @Override
    String typeofengine() {
        return null;
    }
//
//    @Override
//    void register() {
//        System.out.println("Indgio regrister");
//    }

    @Override
    int getSpeed(String aeroname) {
        return 454;
    }

    // we can synchronized the overridden abstract methods
    // but cannnot declared the abstract methods as synchronized in parent class
    @Override
    synchronized void airfuel(int lite) {
        System.out.println(lite);
    }
}

class DemoClass implements DemoInterface {
    @Override
    public void fun() {

    }
}

class HandleErrors {

    static void doubler(int a) {
        doubler(a * a);
    }

    public static void main(String[] args) {
        try {
            doubler(2);
        } catch (StackOverflowError ignored) {

        }
    }
}
