package com.scaler.Scaler.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class FListNode {
    int val;
    FListNode right, down;

    FListNode(int x) {
        val = x;
        right = down = null;
    }
}