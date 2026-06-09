//package com.scaler.Scaler.LinkedList;
//
//public class InsertLinkedList {
//    public ListNode solve(ListNode A, int B, int C) {
//        ListNode temp = A;
//        ListNode newNode = new ListNode(B);
//        if (C == 0) {
//            newNode.next = temp;
//            temp = newNode;
//            return temp;
//        }
//        for (int i = 1; i < C && temp.next != null; i++) {
//            temp = temp.next;
//        }
//        newNode.next = temp.next;
//        temp.next = newNode;
//        return A;
//    }
//}
