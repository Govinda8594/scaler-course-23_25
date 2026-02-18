package com.scaler.LLDProject.Splitwise.services;

import com.scaler.LLDProject.Splitwise.dto.Transaction;
import com.scaler.LLDProject.Splitwise.models.*;
import com.scaler.LLDProject.Splitwise.repository.GroupRepository;
import com.scaler.LLDProject.Splitwise.repository.UserExpenseRepository;
import com.scaler.LLDProject.Splitwise.strategies.SettleStrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private GroupRepository groupRepository;
    private UserExpenseRepository userExpenseRepository;
    private SettleStrategies strategies;

    public UserService(GroupRepository groupRepository, UserExpenseRepository userExpenseRepository, SettleStrategies strategies) {
        this.groupRepository = groupRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.strategies = strategies;
    }

    public List<Transaction> settleUser(String username, String groupName) {
        Map<String, Integer> extraAmountMap = new HashMap<String, Integer>();
        List<Expense> expenseList = groupRepository.findExpenseByGroup(groupName);
        for (Expense expense : expenseList) {
            if (ExpenseType.NORMAL.equals(expense.getType())) {
                List<UserExpense> userExpenses = userExpenseRepository.findExpenseByUserExpense(expense.getDescription());
                for (UserExpense userExpense : userExpenses) {
                    User user = userExpense.getUser();
                    if (!extraAmountMap.containsKey(user.getUsername())) {
                        extraAmountMap.put(user.getUsername(), 0);
                    }
                    Integer extraAmt = extraAmountMap.get(user.getUsername());
                    if (userExpense.getUserExpenseType().equals(UserExpenseType.PAID_BY)) {
                        extraAmt += userExpense.getAmount();
                    } else {
                        extraAmt -= userExpense.getAmount();
                    }
                    extraAmountMap.put(user.getUsername(), extraAmt);
                }
            }
        }
        List<Transaction> transactions = strategies.settleUpGroup(extraAmountMap);
        List<Transaction> userTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getFrom().equals(username) || transaction.getTo().equals(username)) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }
}
