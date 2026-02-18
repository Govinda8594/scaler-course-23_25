package com.scaler.LLDProject.googledrive;// PermissionsDecorator.java

import java.util.HashMap;
import java.util.Map;

public class PermissionsDecorator {
    private final Map<User, Permission> userPermissions;

    public PermissionsDecorator() {
        this.userPermissions = new HashMap<>();
    }

    public void setPermission(User user, Permission permission) {
        userPermissions.put(user, permission);
    }



    public enum Permission {
        READ, WRITE, NONE;
    }
}

// User.java
class User {
    private final String username;
    private final String password;
    private final Role role;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    // Authentication Method
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public enum Role {
        ADMIN, USER
    }
}