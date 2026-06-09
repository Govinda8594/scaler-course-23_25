package com.scaler.LLDProject.Splitwise.controller;

import com.scaler.LLDProject.Splitwise.dto.Transaction;
import com.scaler.LLDProject.Splitwise.services.UserService;

import java.util.List;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<Transaction> settleUser(String username, String groupName) {
        return userService.settleUser(username, groupName);
    }
}
