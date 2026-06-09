package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
//Given a digit string A, return all possible letter combinations that the number could represent.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//        The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
//
//        NOTE: Make sure the returned strings are lexicographically sorted.

public class MappingDigitToNumber_TelephoneNumber {
    ArrayList<String> ans;

    public static void main(String[] args) {
        MappingDigitToNumber_TelephoneNumber m = new MappingDigitToNumber_TelephoneNumber();
        m.letterCombinations("23");
    }

    String getMap(int x) {
        switch (x) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
    }

    public ArrayList<String> letterCombinations(String A) {
        ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        generate(A, curr, 0);
        Collections.sort(ans);
        return ans;
    }

    public void generate(String arr, StringBuilder curr, int j) {
        if (curr.length() == arr.length()) {
            String str = curr.toString();
            ans.add(str);
            return;
        }
        String word = getMap(arr.charAt(j) - '0');
        //Iterate of each word and take just one letter at a time.
        for (int i = 0; i < word.length(); i++) {
            String s = word.charAt(i) + "";
            curr.append(s);
            generate(arr, curr, j + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }


}
