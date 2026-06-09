package com.scaler.LLDProject.Splitwise;


import com.scaler.LLDProject.Splitwise.controller.UserController;
import com.scaler.LLDProject.Splitwise.dto.Transaction;
import com.scaler.LLDProject.Splitwise.models.*;
import com.scaler.LLDProject.Splitwise.repository.ExpenseRepository;
import com.scaler.LLDProject.Splitwise.repository.GroupRepository;
import com.scaler.LLDProject.Splitwise.repository.UserExpenseRepository;
import com.scaler.LLDProject.Splitwise.repository.UserRepository;
import com.scaler.LLDProject.Splitwise.services.UserService;
import com.scaler.LLDProject.Splitwise.strategies.HeapSettleStrategy;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
        // Press Shift+F9 to start debugging your code. We have set one breakpoint
        // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);
        UserRepository userRepository = new UserRepository();
        ExpenseRepository expenseRepository = new ExpenseRepository();
        GroupRepository groupRepository = new GroupRepository();
        UserExpenseRepository userExpenseRepository = new UserExpenseRepository();
        User govinda = new User("govinda", "456465", "64545");
        User radha = new User("radha", "456465", "64545");
        User rakhi = new User("rakhi", "456465", "64545");
        User mala = new User("mala", "456465", "64545");
        User dhirti = new User("dhirti", "456465", "64545");
        ArrayList<User> goaguys = new ArrayList<>();
        goaguys.add(govinda);
        goaguys.add(radha);
        goaguys.add(rakhi);
        goaguys.add(mala);
        goaguys.add(dhirti);
        Group goatrip = new Group("goatrip");
        goatrip.setUserList(goaguys);
        Expense expense = new Expense("Dinner", 6000, ExpenseType.NORMAL);
        UserExpense expense1 = new UserExpense(govinda, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense expense2 = new UserExpense(rakhi, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense expense3 = new UserExpense(radha, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense expense4 = new UserExpense(mala, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense expense5 = new UserExpense(dhirti, expense, 2000, UserExpenseType.HAD_TO_PAY);
        UserExpense expense6 = new UserExpense(govinda, expense, 6000, UserExpenseType.PAID_BY);

        userExpenseRepository.addUserExpense(expense1);
        userExpenseRepository.addUserExpense(expense2);
        userExpenseRepository.addUserExpense(expense3);
        userExpenseRepository.addUserExpense(expense4);
        userExpenseRepository.addUserExpense(expense5);
        userExpenseRepository.addUserExpense(expense6);

        userRepository.addUser(govinda);
        userRepository.addUser(radha);
        userRepository.addUser(rakhi);
        userRepository.addUser(mala);
        userRepository.addUser(dhirti);
        expenseRepository.addExp(expense);
        goatrip.getExpenseList().add(expense);
        groupRepository.addGroup(goatrip);
        UserController userController = new UserController(new UserService(groupRepository, userExpenseRepository, new HeapSettleStrategy()));
        List<Transaction> transactions = userController.settleUser("govinda", "goatrip");
        System.out.println(transactions);
    }
}