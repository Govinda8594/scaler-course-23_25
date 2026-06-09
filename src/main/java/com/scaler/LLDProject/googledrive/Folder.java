package com.scaler.LLDProject.googledrive;// Folder.java

import java.util.HashMap;
import java.util.Map;

public class Folder implements FileSystemComponent {
    private String name;
    private final Map<String, FileSystemComponent> children;
    private final PermissionsDecorator permissions;

    public Folder(String name) {
        this.name = name;
        this.children = new HashMap<>();
        this.permissions = new PermissionsDecorator();
    }

    // Composite Pattern Methods
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(FileSystemComponent component) {
        if (component == null || component.getName() == null) {
            throw new IllegalArgumentException("Component or component name cannot be null");
        }

        children.put(component.getName(), component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        if (component == null) return;
        children.remove(component.getName());
    }

    @Override
    public FileSystemComponent getChild(String name) {
        FileSystemComponent child = children.get(name);
        if (child == null) {
            throw new UnsupportedOperationException("Child not found: " + name);
        }
        return child;

    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemComponent component : children.values()) {
            component.display(indent + "    ");
        }
    }

    public Map<String, FileSystemComponent> getChildren() {
        return children;
    }

    public PermissionsDecorator getPermissions() {
        return permissions;
    }
}