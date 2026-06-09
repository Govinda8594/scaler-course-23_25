package com.scaler.DesignPattern.behavioral.command;
//The Command pattern encapsulates a request as an object,
// allowing you to parameterize clients with different requests,
// queue requests,
// or support undoable operations.
public interface Command {
    void execute();
}
