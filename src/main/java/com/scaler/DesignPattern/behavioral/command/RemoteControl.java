package com.scaler.DesignPattern.behavioral.command;

public class RemoteControl {
    private Command command;
    void setCommand(Command cmd){
        this.command = cmd;
    }

    void execute(){
        command.execute();
    }
}
