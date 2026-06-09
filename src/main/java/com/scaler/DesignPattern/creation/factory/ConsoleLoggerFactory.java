package com.scaler.DesignPattern.creation.factory;

public class ConsoleLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new ConsoleLogger();
    }
}
