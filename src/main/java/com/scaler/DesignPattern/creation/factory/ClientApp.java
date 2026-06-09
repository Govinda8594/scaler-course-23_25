package com.scaler.DesignPattern.creation.factory;

public class ClientApp {
    static void main() {
        LoggerFactory fileLoggerFactory = new FileLoggerFactory();
        Logger logger = fileLoggerFactory.createLogger();
        logger.log("Hello");

        LoggerFactory consoleLoggerFactory = new ConsoleLoggerFactory();
        logger = consoleLoggerFactory.createLogger();
        logger.log("Hello");
    }
}
