package com.scaler.DesignPattern.creation.abstractfactory;

public interface GUIFactory {
    // factory interface for create family of related Object
    // or dependent Object without specify concrete class
    Button createButton();
    Menu createMenu();
}

//UIFactory
//createButton() createCheckbox()
//        /              \
//        /                \
//WindowsFactory          MacFactory
//       |                       |
//               |                       |
//WindowsButton             MacButton
//WindowsCheckbox           MacCheckbox