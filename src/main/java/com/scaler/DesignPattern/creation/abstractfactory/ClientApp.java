package com.scaler.DesignPattern.creation.abstractfactory;

public class ClientApp {
    static void main() {
        GUIFactory guiFactory = new WindowFactory();
        Button button = guiFactory.createButton();
        Menu menu = guiFactory.createMenu();
        button.render();
        menu.display();

        // same MAC
    }
}
