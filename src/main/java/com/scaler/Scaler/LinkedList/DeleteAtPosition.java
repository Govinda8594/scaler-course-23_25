package com.scaler.Scaler.LinkedList;
//You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
//        Note : Follow 0-based indexing for the node numbering.
public class DeleteAtPosition {
    public ListNode solve(ListNode A, int B) {
        int count = 0;
        ListNode current = A;
          if (B == 0) {
            return A.next;
        }
        else {
        while(count < B - 1){
            current = current.next;
            count++;
        }
        current.next = current.next.next;
        }
        return A;
    }
}