package com.scaler.DesignPattern.behavioral.command;

public class Main {
    static void main() {
        RemoteControl rc = new RemoteControl();
        Light light = new Light();
        rc.setCommand(new TurnOffLightCommand(light));
        rc.execute();
    }
}
