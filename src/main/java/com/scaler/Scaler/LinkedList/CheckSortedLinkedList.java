package com.scaler.Scaler.LinkedList;
public class CheckSortedLinkedList {
    public int solve(ListNode A) {
        ListNode previous = A;
        if (previous.next == null) {
            return 1;
        }
        ListNode currrent = A.next;
        while(currrent != null){
            if (previous.val > currrent.val) {
                return 0;
            }
            previous = currrent;
            currrent =  currrent.next;   
        }
        return 1;
    }
}