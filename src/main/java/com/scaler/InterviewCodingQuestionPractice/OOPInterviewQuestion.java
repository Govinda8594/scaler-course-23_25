package com.scaler.InterviewCodingQuestionPractice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/*
    Functional Interface:
    ---------------------
    A functional interface has exactly one abstract method.
    It can be implemented using:
    1. Normal class
    2. Anonymous class
    3. Lambda expression
 */
@FunctionalInterface
interface DemoInterface {
    void fun();
}

/*
    Main public class.
    In Java, one file can have only one public top-level class.
    File name must be same as public class name:
    OOPInterviewQuestion.java
 */
public class OOPInterviewQuestion {

    public static void main(String[] args) {

        /*
            Constructor Chaining Concept:
            -----------------------------
            If parent class does not have a default constructor,
            then child class constructor must explicitly call parent
            parameterized constructor using super(...).
         */

        Vehicle v = new Car("Car object created using parent reference");
        v.speed();

        Vehicle v2 = new Vehicle("Vehicle object created");
        v2.speed();

        /*
            Abstract Class Concept:
            -----------------------
            We cannot create object of abstract class directly.

            Invalid:
            AirService service = new AirService();

            But we can create child class object and store it in
            abstract class reference.
         */

        AirService service = new Indigo();

        /*
            register() is concrete method in abstract parent class.

            If child overrides register(), child version will be called.
            If child does not override register(), parent version will be called.
         */
        service.register();

        /*
            typeofEngine() is abstract method in parent class.
            Child class must implement it.
            At runtime, child class method is called.
         */
        service.typeofEngine();

        Indigo indigo = new Indigo();

        /*
            Here reference type and object type both are Indigo.
            register() is not overridden in Indigo,
            so parent class register() will be called.
         */
        indigo.register();
        indigo.typeofEngine();

        /*
            Interface Object Creation:
            --------------------------
            We cannot directly create object of interface because
            interface is incomplete.

            Invalid:
            DemoInterface obj = new DemoInterface();

            But we can use:
            1. Implementation class
            2. Anonymous class
            3. Lambda expression
         */

        // Way 1: Using implementation class
        DemoClass way1 = new DemoClass();
        way1.fun();

        // Way 2: Anonymous class
        DemoInterface way2 = new DemoInterface() {
            @Override
            public void fun() {
                System.out.println("Anonymous class implementation of DemoInterface");
            }
        };
        way2.fun();

        // Way 3: Lambda expression
        DemoInterface way3 = () -> {
            System.out.println("Lambda implementation of DemoInterface");
        };
        way3.fun();

        /*
            Predicate Functional Interface:
            -------------------------------
            Predicate<T> takes one input and returns boolean.
         */

        // Anonymous class implementation of Predicate
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.length() > 10;
            }
        };

        System.out.println(predicate.test("Scaler"));
        System.out.println(predicate.test("Scaler School of Technology"));

        // Lambda implementation of Predicate
        Predicate<String> predicate1 = str -> str.length() > 10;
        System.out.println(predicate1.test("Scaler School of Technology"));

        /*
            BiFunction Functional Interface:
            --------------------------------
            BiFunction<T, U, R> takes two inputs and returns one output.
         */
        BiFunction<String, String, String> biFunction = (a, b) -> a + b;
        System.out.println(biFunction.apply("Hello ", "World!"));

        /*
            TreeSet Concept:
            ----------------
            TreeSet stores unique elements in sorted order.
         */

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(List.of(10, 20, 5, 6, 7, 3, 4, 8));

        System.out.println("TreeSet safe removal using Iterator:");

        /*
            Safe Removal:
            -------------
            While iterating a collection, if we want to remove an element,
            we should use Iterator's remove() method.
         */
        Iterator<Integer> iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            int element = iterator.next();

            if (element == 5) {
                iterator.remove();
            } else {
                System.out.println(element);
            }
        }

        /*
            ConcurrentModificationException:
            --------------------------------
            Removing directly from collection while using enhanced for-loop
            can throw ConcurrentModificationException.

            Example:
            for (Integer x : treeSet) {
                if (x == 7) {
                    treeSet.remove(x); // Unsafe
                }
            }

            So below code is commented.
         */

        /*
        System.out.println("TreeSet unsafe removal:");

        for (Integer x : treeSet) {
            if (x == 7) {
                treeSet.remove(Integer.valueOf(x));
            }
            System.out.println(x);
        }
        */

        /*
            Stream reduce() Concept:
            ------------------------
            reduce() is used to combine stream elements into one result.
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer sumOfNumbers = numbers.stream()
                .reduce(0, (sum, ele) -> sum + ele);

        Integer max = numbers.stream()
                .reduce(Integer.MIN_VALUE, (currMax, ele) -> Math.max(currMax, ele));

        System.out.println("sumOfNumbers = " + sumOfNumbers);
        System.out.println("max = " + max);

        Integer maxWithReduce = numbers.stream()
                .reduce(Integer.MIN_VALUE, (currMax, ele) -> Math.max(currMax, ele));

        System.out.println("maxWithReduce = " + maxWithReduce);

        /*
            Overloading, Overriding and Reference Type Concept:
            ---------------------------------------------------
         */
    }

    /*
        Parent Class Constructor Concept:
        ---------------------------------
        Vehicle has only parameterized constructor.
        Therefore child class must call super(type).
        Otherwise Java tries to call super() automatically and fails.
     */
    static class Vehicle {

        public Vehicle(String type) {
            System.out.println(type);
        }

        int speed() {
            System.out.println("Called from Vehicle parent class");
            return 0;
        }
    }

    /*
        Child Class Constructor Concept:
        --------------------------------
        Since Vehicle does not have default constructor,
        Car constructor must call super(type).
     */
    static class Car extends Vehicle {
        public Car(String type) {
            super(type);
        }

        @Override
        int speed() {
            System.out.println("Called from Car child class");
            return 0;
        }
    }
}

/*
    Abstract Class Concept:
    -----------------------
    1. Abstract class can have constructor.
    2. Abstract class can have abstract methods.
    3. Abstract class can have concrete methods.
    4. Abstract class can have static methods.
    5. Abstract class cannot be instantiated directly.
 */
abstract class AirService {

    AirService() {
        System.out.println("AirService constructor called");
    }

    /*
        Static method inside abstract class is allowed.

        But this is invalid:
        static abstract void servicePlanNo();

        Because static methods belong to class,
        while abstract methods need overriding.
     */
    static void servicePlanNo() {
        System.out.println("Inside static parent method");
    }

    /*
        Abstract method:
        ----------------
        Child class must implement this method.
     */
    abstract String typeofEngine();

    /*
        Concrete method:
        ----------------
        Child class may override this method.
        If not overridden, parent version will be called.
     */
    void register() {
        System.out.println("Registering from AirService");
    }

    int getSpeed(String aeroName) {
        return 2;
    }

    /*
        Invalid combination:
        --------------------
        abstract synchronized void airFuel(int litre);

        Abstract method has no body.
        synchronized is meaningful for method body execution.
        So parent abstract method cannot be synchronized.
     */
    abstract void airFuel(int litre);
}

/*
    Child class of abstract class:
    ------------------------------
    Indigo must implement all abstract methods of AirService.
 */
class Indigo extends AirService {

    @Override
    String typeofEngine() {
        System.out.println("Indigo engine type called");
        return "Jet Engine";
    }

    /*
        If this method is uncommented, child version will be called.

        @Override
        void register() {
            System.out.println("Registering from Indigo");
        }
     */

    @Override
    int getSpeed(String aeroName) {
        return 454;
    }

    /*
        We can make overridden method synchronized in child class.
     */
    @Override
    synchronized void airFuel(int litre) {
        System.out.println("Fuel in litre = " + litre);
    }
}

/*
    Normal class implementing functional interface.
 */
class DemoClass implements DemoInterface {

    @Override
    public void fun() {
        System.out.println("DemoClass implementation of DemoInterface");
    }
}

/*
    StackOverflowError Example:
    ---------------------------
    Recursive method without base condition causes StackOverflowError.
 */
class HandleErrors {

    static void doubler(int a) {
        doubler(a * a);
    }

    public static void main(String[] args) {
        try {
            doubler(2);
        } catch (StackOverflowError ignored) {
            System.out.println("StackOverflowError handled");
        }
    }
}

/*
    Interface C:
    ------------
    Contains add(double).
 */
interface C {
    int add(double i);
}

/*
    Abstract class B:
    -----------------
    Constructor of parent class is called before child class constructor.
 */
abstract class B {

    B() {
        System.out.println("Inside constructor B");
    }

    int add(int i) {
        return i;
    }
}

/*
    Final Class:
    ------------
    final class cannot be inherited.
 */
final class A extends B implements C {

    public C r;

    public A() {
        super();
        System.out.println("Inside constructor A");
    }

    public A(C c) {
        super();
        r = c;
        System.out.println("Inside constructor A with C");
    }

    /*
        Overriding:
        -----------
        B class has add(int).
        A class overrides add(int).
     */
    @Override
    public int add(int i) {
        System.out.println("int method called");
        return i;
    }

    /*
        Overloading:
        ------------
        Same method name but different parameter type.
     */
    public void add(long i) {
        System.out.println("long method called");
    }

    /*
        Interface C has add(double).
        A class implements it.
     */
    @Override
    public int add(double i) {
        System.out.println("double method called");
        return (int) i;
    }

    /*
        Calling parent class method using super.
     */
    void callSuperAdd(int x) {
        int result = super.add(x);
        System.out.println("super add result: " + result);
    }

    public static void main(String[] args) {
        A c = new A();

        c.add(10);       // calls add(int)
        c.add(10L);      // calls add(long)
        c.add(10.5);     // calls add(double)

        int i = c.add(10); // A class call

        c.callSuperAdd(10); // B class call

        C ref = new A();
           /*
            Reference type is C.
            Interface C has method add(double).

            So ref.add(10) is resolved using C's method signature.
            int 10 is promoted to double.
            At runtime, A class overridden add(double) is called.
         */
        ref.add(10);     // calls add(double) overridden, because reference type is C
    }

//Inside constructor B
//Inside constructor A
//print i
//long method called
//double method called
//print i
//super add result: 10 //
//Inside constructor B
//Inside constructor A
//double method called
}

/*
    ================================
    CONSTRUCTOR INTERVIEW SCENARIOS
    ================================

    Rule:
    If parent class has only parameterized constructor,
    then child constructor must explicitly call super(arguments).

    Java automatically inserts super() in child constructor
    if we do not write super(...) manually.

    But if parent does not have default constructor,
    then super() will fail.
*/

//1. Constructor Error Scenarios
class ParentWithParameterizedConstructor {

    ParentWithParameterizedConstructor(String name) {
        System.out.println("Parent constructor called: " + name);
    }
}

class ValidChild extends ParentWithParameterizedConstructor {

    ValidChild() {
        super("ValidChild"); // Correct
        System.out.println("ValidChild constructor called");
    }
}

/*
    ERROR SCENARIO 1:
    -----------------
    This will not compile.

    Reason:
    Parent has no default constructor.
    Java tries to call super() automatically.
    But super() does not exist in parent.

class InvalidChild extends ParentWithParameterizedConstructor {

    InvalidChild() {
        // Java internally adds super();
        // But ParentWithParameterizedConstructor has no default constructor.
        System.out.println("InvalidChild constructor called");
    }
}
*/

// Abstract Class Error Scenarios
/*
    ============================
    ABSTRACT CLASS SCENARIOS
    ============================

    Rules:
    1. Abstract class cannot be instantiated.
    2. Abstract class can have constructor.
    3. Abstract class can have abstract and concrete methods.
    4. Child class must implement all abstract methods.
*/

abstract class PaymentService {

    PaymentService() {
        System.out.println("PaymentService constructor called");
    }

    abstract void pay();

    void validatePayment() {
        System.out.println("Payment validated");
    }
}

class UpiPayment extends PaymentService {

    @Override
    void pay() {
        System.out.println("UPI payment done");
    }
}

/*
    ERROR SCENARIO 2:
    -----------------
    Cannot create object of abstract class.

    Reason:
    Abstract class is incomplete because it may have abstract methods.

class AbstractClassObjectTest {
    public static void main(String[] args) {
        PaymentService service = new PaymentService(); // CT error
    }
}
*/

/*
    ERROR SCENARIO 3:
    -----------------
    Child class must implement abstract methods.

    Reason:
    If child does not implement pay(),
    then child class must also be declared abstract.

class CardPayment extends PaymentService {
    // pay() not implemented
}
*/

/*
    Valid alternative:
*/
abstract class CardPayment extends PaymentService {
    // This is valid because CardPayment is also abstract.
}

/*
    ==================================
    STATIC AND ABSTRACT METHOD ERROR
    ==================================

    Rule:
    static and abstract cannot be used together.

    Reason:
    static method belongs to class.
    abstract method needs runtime overriding.

    These two concepts conflict.
    Static methods are resolved by class name, not by runtime object.
    Abstract methods are resolved by runtime object.
    That is why this is invalid:
*/

abstract class StaticAbstractExample {

    /*
        ERROR SCENARIO 4:
        -----------------

        static abstract void show();

        Compile-time error:
        illegal combination of modifiers: abstract and static
    */

    static void validStaticMethod() {
        System.out.println("Static method is allowed in abstract class");
    }

    abstract void validAbstractMethod();
}

/*
    ======================
    INTERFACE SCENARIOS
    ======================

    Rules:
    1. Interface object cannot be created directly.
    2. Interface reference can point to implementation class object.
    3. Functional interface can be implemented using lambda.
*/

interface NotificationService {
    void send();
}

class EmailNotification implements NotificationService {

    @Override
    public void send() {
        System.out.println("Email sent");
    }
}

class InterfaceScenarioTest {

    public static void main(String[] args) {

        NotificationService service = new EmailNotification();
        service.send();

        NotificationService lambdaService = () -> System.out.println("Lambda notification sent");
        lambdaService.send();

        /*
            ERROR SCENARIO 5:
            -----------------
            Cannot instantiate interface.

            Reason:
            Interface methods are incomplete.

            NotificationService obj = new NotificationService();
        */
    }
}
/*
    ==============================
    FUNCTIONAL INTERFACE SCENARIO
    ==============================

    Rule:
    Functional interface can have only one abstract method.
*/

@FunctionalInterface
interface Calculator {
    int add(int a, int b);

    /*
        ERROR SCENARIO 6:
        -----------------
        If we uncomment below method, compile-time error occurs.

        Reason:
        Functional interface can have only one abstract method.

        int subtract(int a, int b);
    */

    /*
        This is allowed:
        default method is not counted as abstract method.
    */
    default void printInfo() {
        System.out.println("Calculator functional interface");
    }

    /*
        This is also allowed:
        static method is not counted as abstract method.
    */
    static void show() {
        System.out.println("Static method inside interface");
    }
}

/*
    ==================================
    OVERLOADING VS OVERRIDING SCENARIO
    ==================================
*/

class Animal {

    void sound() {
        System.out.println("Animal sound");
    }

    Number getValue() {
        return 10;
    }
}

class Dog extends Animal {

    /*
        Valid overriding:
        Method name, parameter list should be same.
    */
    @Override
    void sound() {
        System.out.println("Dog barking");
    }

    /*
        Valid covariant return type:
        Integer is child class of Number.
    */
    @Override
    Integer getValue() {
        return 20;
    }

    /*
        ERROR SCENARIO 7:
        -----------------
        This is not overriding.
        This is overloading because parameter changed.

        If @Override is used, compile-time error occurs.

        @Override
        void sound(String type) {
            System.out.println(type);
        }
    */

    /*
        ERROR SCENARIO 8:
        -----------------
        Return type cannot be unrelated.

        Object is parent of Number, not child.
        So this is invalid while overriding.

        @Override
        Object getValue() {
            return 10;
        }
    */
}
/*
    ==========================
    STATIC METHOD HIDING
    ==========================

    Static methods are not overridden.
    They are hidden.

    Method call depends on reference type,
    not object type.
*/

class ParentStatic {

    static void show() {
        System.out.println("Parent static show");
    }

    void display() {
        System.out.println("Parent display");
    }
}

class ChildStatic extends ParentStatic {

    static void show() {
        System.out.println("Child static show");
    }

    @Override
    void display() {
        System.out.println("Child display");
    }
}

class StaticMethodTest {

    public static void main(String[] args) {

        ParentStatic obj = new ChildStatic();

        obj.show();    // Parent static show
        obj.display(); // Child display

        /*
            Explanation:
            show() is static, so it depends on reference type: ParentStatic.
            display() is non-static, so it depends on runtime object: ChildStatic.
        */
    }
}

/*
    =====================
    FINAL KEYWORD
    =====================
*/

final class FinalParent {
    void show() {
        System.out.println("Final class method");
    }
}

/*
    ERROR SCENARIO 9:
    -----------------
    Cannot inherit final class.

class ChildOfFinal extends FinalParent {

}
*/

class FinalMethodParent {

    final void display() {
        System.out.println("Final method");
    }
}

class FinalMethodChild extends FinalMethodParent {

    /*
        ERROR SCENARIO 10:
        ------------------
        Cannot override final method.

        @Override
        void display() {
            System.out.println("Trying to override");
        }
    */
}

class FinalVariableExample {

    final int value;

    FinalVariableExample(int value) {
        this.value = value;
    }

    void test() {
        /*
            ERROR SCENARIO 11:
            ------------------
            Final variable cannot be reassigned.

            value = 100;
        */
    }
}

/*
    ================================
    PRIVATE METHOD IS NOT OVERRIDDEN
    ================================
*/

class PrivateParent {

    private void show() {
        System.out.println("PrivateParent show");
    }

    void callShow() {
        show();
    }
}

class PrivateChild extends PrivateParent {

    /*
        This is not overriding.
        This is a new method of child class.
    */
    private void show() {
        System.out.println("PrivateChild show");
    }
}

class PrivateMethodTest {

    public static void main(String[] args) {

        PrivateChild child = new PrivateChild();
        child.callShow();

        /*
            Output:
            PrivateParent show

            Reason:
            private methods are not inherited.
            So they cannot be overridden.
        */
    }
}
/*
    =========================
    CONSTRUCTOR IS NOT INHERITED
    =========================
*/

class BaseConstructor {

    BaseConstructor() {
        System.out.println("Base constructor");
    }
}

class DerivedConstructor extends BaseConstructor {

    DerivedConstructor() {
        super();
        System.out.println("Derived constructor");
    }
}

/*
    Interview Point:
    Constructor is not inherited.
    But parent constructor is always called before child constructor.
*/

/*
    ERROR SCENARIO 12:
    ------------------
    Constructor cannot be overridden.

    Reason:
    Constructor name must be same as class name.
    Parent and child class names are different.

class ParentConstructorOverride {
    ParentConstructorOverride() {

    }
}

class ChildConstructorOverride extends ParentConstructorOverride {

    @Override
    ParentConstructorOverride() {
        // Invalid
    }
}
*/

/*
    ==============================
    EXCEPTION OVERRIDING RULE
    ==============================

    Rule:
    Child overridden method cannot throw broader checked exception.
*/

class ExceptionParent {

    void readFile() throws java.io.IOException {
        System.out.println("Parent readFile");
    }
}

class ExceptionChild extends ExceptionParent {

    /*
        Valid:
        Same checked exception.
    */
    @Override
    void readFile() throws java.io.IOException {
        System.out.println("Child readFile");
    }

    /*
        ERROR SCENARIO 13:
        ------------------
        Exception is broader than IOException.

        @Override
        void readFile() throws Exception {
            System.out.println("Invalid");
        }
    */
}
/*
    ====================================
    ACCESS MODIFIER OVERRIDING RULE
    ====================================

    Rule:
    Child class cannot reduce visibility of overridden method.

    public    -> must remain public
    protected -> protected or public
    default   -> default, protected, or public
*/

class AccessParent {

    protected void show() {
        System.out.println("Parent protected show");
    }
}

class AccessChild extends AccessParent {

    /*
        Valid:
        protected to public is allowed.
    */
    @Override
    public void show() {
        System.out.println("Child public show");
    }

    /*
        ERROR SCENARIO 14:
        ------------------
        Cannot reduce visibility from protected to private.

        @Override
        private void show() {
            System.out.println("Invalid");
        }
    */
}
/*
    ====================================
    CONCURRENT MODIFICATION EXCEPTION
    ====================================
*/

class CollectionErrorScenario {

    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(List.of(10, 20, 5, 6, 7));

        /*
            ERROR SCENARIO 15:
            ------------------
            Removing directly from collection while using enhanced for-loop
            may throw ConcurrentModificationException.

        for (Integer x : set) {
            if (x == 5) {
                set.remove(x);
            }
        }
        */

        /*
            Correct way:
            Use Iterator remove().
        */
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            Integer x = iterator.next();

            if (x == 5) {
                iterator.remove();
            }
        }

        System.out.println(set);
    }
}

/*
    =============================
    ARRAY SORTING ERROR SCENARIO
    =============================
*/

class ArraySortingScenario {

    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1};

        Arrays.sort(arr); // Ascending only for primitive int[]

        /*
            ERROR SCENARIO 16:
            ------------------
            Comparator does not work with primitive int[].

            Arrays.sort(arr, (a, b) -> b - a);

            Reason:
            Comparator works with object arrays like Integer[],
            not primitive arrays like int[].
        */

        Integer[] nums = {5, 2, 9, 1};

        Arrays.sort(nums, (a, b) -> b - a); // Valid descending sort

        System.out.println(Arrays.toString(nums));
    }
}
//        Best Interview Revision Notes
//        Very Common OOP Interview Questions
//1. Can abstract class have constructor?
//        Yes.
//                Javaabstract class A {    A() {        System.out.println("Constructor");    }}Show more lines
//        Constructor is called when child object is created.
//
//        2. Can interface have constructor?
//        No.
//        Javainterface A {    // A() {} // invalid}Show more lines
//        Reason: interface cannot maintain object construction logic like a class.
//
//        3. Can abstract class have static method?
//        Yes.
//                Javaabstract class A {    static void show() {}}Show more lines
//
//4. Can abstract method be static?
//        No.
//                Javaabstract class A {    // static abstract void show(); // invalid}``Show more lines
//
//5. Can final method be overridden?
//    No.
//
//6. Can private method be overridden?
//    No. Private method is not inherited.
//
//7. Can constructor be overridden?
//    No. Constructor is not inherited.
//
//            8. Can constructor be overloaded?
//    Yes.
//    Javaclass A {    A() {}    A(int x) {}}Show more lines
//
//9. Can main method be overloaded?
//    Yes.
//            Javapublic static void main(String[] args) {}public static void main(int x) {}Show more lines
//    But JVM calls only:
//    Javapublic static void main(String[] args)Show more lines
//
//10. Can static method be overridden?
//    No. Static method is hidden, not overridden.
