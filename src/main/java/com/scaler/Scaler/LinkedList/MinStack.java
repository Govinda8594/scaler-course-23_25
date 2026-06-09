package com.scaler.Scaler.LinkedList;

public class MinStack {
    class ListNode {
        int val;
        int min;
        ListNode next;
        ListNode(int data) {
            val = data;
            min = data;
            next = null;
        }
    }

    ListNode head;

    public void push(int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            head = newNode;
            return;
        }
        int headMin = head.min;
        newNode.next = head;
        newNode.min = Math.min(newNode.min, headMin);
        head = newNode;
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public int top() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public int getMin() {
        if (head == null) {
            return -1;
        }
        return head.min;
    }
}
