package com.scaler.LLDProject.googledrive;

import java.util.ArrayList;
import java.util.List;

// Observer.java
public interface Observer {
    void update(String message);
}

// Subject.java
class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}