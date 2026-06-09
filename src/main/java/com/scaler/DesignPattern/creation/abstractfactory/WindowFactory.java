package com.scaler.DesignPattern.creation.abstractfactory;

public class WindowFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return null;
    }

    @Override
    public Menu createMenu() {
        return null;
    }
}
