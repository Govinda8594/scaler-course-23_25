package com.scaler.LLDProject.Splitwise.repository;

import com.scaler.LLDProject.Splitwise.models.Expense;
import com.scaler.LLDProject.Splitwise.models.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private List<Group> groupList;

    public GroupRepository() {
        this.groupList = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public List<Expense> findExpenseByGroup(String groupName) {
        for (Group group : groupList) {
            if (groupName.equals(group.getName())) {
                return group.getExpenseList();
            }
        }
        return new ArrayList<>();
    }
}
