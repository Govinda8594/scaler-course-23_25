package com.scaler.Scaler.LinkedList;

public class KthElementinLinkedList {
        public int solve(ListNode A, int B) {
            if (B == 0) return A.val;
            ListNode temp = A.next;
            for (int i = 1; i < B && temp.next != null; i++) {
                temp = temp.next;
            }
            return temp.val;
        }
}
