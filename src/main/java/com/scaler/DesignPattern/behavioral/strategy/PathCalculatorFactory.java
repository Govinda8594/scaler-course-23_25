package com.scaler.DesignPattern.behavioral.strategy;

public class PathCalculatorFactory {
    public static PathCalculatorStrategy getPathCalculator(TransportationMode mode) {
        return switch (mode) {
            case CAR -> CarPathCalculatorStrategy.getInstance();
            case BIKE -> BikePathCalculatorStrategy.getInstance();
            case WALK -> WalkPathCalculatorStrategy.getInstance();
        };
    }
}
