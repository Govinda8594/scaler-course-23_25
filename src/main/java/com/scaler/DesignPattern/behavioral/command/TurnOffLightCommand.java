package com.scaler.DesignPattern.behavioral.command;

public class TurnOffLightCommand implements Command{
    private Light light;

    TurnOffLightCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        this.light.turnOff();
    }
}
