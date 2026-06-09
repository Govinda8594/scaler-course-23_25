package com.scaler.Scaler.Recursion;

import java.util.ArrayList;

//Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
public class GenerateParanthesis {
    static ArrayList<String> ans = new ArrayList<>();

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<String> generateParenthesis(int A) {
        ans = new ArrayList<String>();
        String str = new String();
        solve(A, 0, 0, str);
        return ans;
    }

    public static void solve(int num, int countOpen, int countClose, String str) {
        // base case
        if (countOpen == countClose && countOpen == num) {
            ans.add(str);
            return;
        }
        if (countOpen < num) {
            solve(num, countOpen + 1, countClose, str + "(");
        }
        if (countClose < countOpen) {
            solve(num, countOpen, countClose + 1, str + ")");
        }
    }

    public void generate(int A, String S, int OpenBraces, int CloseBraces) {
        if (S.length() == 2 * A) { // contains equal number of brackets
            ans.add(S);
            return;
        }
        if (OpenBraces < A) { // Conditions to continue
            generate(A, S + "(", OpenBraces + 1, CloseBraces);
            // close count is less than OpenBraces keep on adding Close brackets
        }
        if (CloseBraces < OpenBraces) {
            generate(A, S + ")", OpenBraces, CloseBraces + 1);
        }
    }

    public ArrayList<String> generateParenthesis1(int A) {
        int OpenBraces = 0, CloseBraces = 0; // initially both brackets are 0
        generate(A, "", OpenBraces, CloseBraces); // recursive call
        return ans;
    }
}
