package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;

//Given a string A, partition A such that every string of the partition is a palindrome.
//
//        Return all possible palindrome partitioning of A.
//
//        Ordering the results in the answer : Entry end will come before Entry j if :
//        len(Entryi[0]) < len(Entryj[0]) OR
//        (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
//        (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))

public class CheckEachPartitionPalindrome {
    public ArrayList<ArrayList<String>> partition1(String A) {
        ArrayList<ArrayList<String>> response = new ArrayList<>();
        ArrayList<String> currentList = new ArrayList<>();
        addBreakPoint(0, A, currentList, response);
        return response;
    }

    public void addBreakPoint(int start, String A, ArrayList<String> currentList, ArrayList<ArrayList<String>> response) {
        if (start == A.length()) {
            response.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start; end < A.length(); end++) {
            if (isPalindrome(A, start, end)) {
                currentList.add(A.substring(start, end + 1));
                addBreakPoint(end + 1, A, currentList, response);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String A, int s, int e) {
        while (s < e) {
            if (A.charAt(s) != A.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
