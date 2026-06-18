package com.scaler.DesignPattern.solid.isp;

class RobotWorker implements Worker {

    @Override
    public void work() {
        System.out.println("Robot is working");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robot does not eat");
    }
}

class RobotWorker3 implements Workable {

    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}

interface Workable2 {
    void work();
}

interface Eatable2 {
    void eat();
}

class HumanWorker2 implements Workable, Eatable {

    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
}

class RobotWorker2 implements Workable {

    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}

 class Main1 {
    public static void main(String[] args) {

        Workable human = new HumanWorker2();
        human.work();

        Workable robot = new RobotWorker2();
        robot.work();

        Eatable eatingHuman = new HumanWorker2();
        eatingHuman.eat();
    }
}