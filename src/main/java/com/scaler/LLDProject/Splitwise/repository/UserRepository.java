package com.scaler.LLDProject.Splitwise.repository;

import com.scaler.LLDProject.Splitwise.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<User>();
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
