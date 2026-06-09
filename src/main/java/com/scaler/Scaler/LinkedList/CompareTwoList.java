package com.scaler.Scaler.LinkedList;

public class CompareTwoList {
    public int solve(ListNode A, ListNode B) {

        while (A != null && B != null) {
            if (A.val != B.val) {
                return 0;
            }
            A = A.next;
            B = B.next;
        }
        if (A != null || B != null) {
            return 0;
        }
        return 1;
    }
}