package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

//Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.
//
//        Return all possible results.
//
//        You can return the results in any order.

public class ReturnAllValidParanthese {

    ArrayList<ArrayList<Character>> ans;

    public ArrayList<String> solve(String A) {
        ans = new ArrayList<>();
        parenthesis(0, 0, 0, A, new ArrayList<>());
        ans.sort(new customComparator());
        int len = ans.get(0).size();
        HashSet<String> set = new HashSet<>();
        for (ArrayList<Character> an : ans) {
            if (an.size() < len) {
                break;
            }
            StringBuilder str = new StringBuilder();
            for (char c : an) {
                str.append(c);
            }
            set.add(str.toString());
        }
        return new ArrayList<>(set);
    }

    private void parenthesis(int index, int open, int close, String A, ArrayList<Character> arrangement) {
        if (index == A.length()) {
            if (open == close) {
                ans.add(new ArrayList<>(arrangement));
            }
            return;
        }
        char ch = A.charAt(index);
        if (ch == '(') {
            arrangement.add(ch);
            parenthesis(index + 1, open + 1, close, A, arrangement);
            arrangement.remove(arrangement.size() - 1);
        } else if (ch == ')' && open > close) {
            arrangement.add(ch);
            parenthesis(index + 1, open, close + 1, A, arrangement);
            arrangement.remove(arrangement.size() - 1);
        } else if (ch >= 'a' && ch <= 'z') {
            arrangement.add(ch);
            parenthesis(index + 1, open, close, A, arrangement);
            arrangement.remove(arrangement.size() - 1);
        }
        parenthesis(index + 1, open, close, A, arrangement);
    }

    static class customComparator implements Comparator<ArrayList<Character>> {
        @Override
        public int compare(ArrayList<Character> a, ArrayList<Character> b) {
            return b.size() - a.size();
        }
    }
}
