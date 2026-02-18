//package com.scaler.Scaler.LinkedList;
//
//public class DeleteMiddleNode {
//
//    /**
//     * Definition for singly-linked list.
//     * class ListNode {
//     *     public int val;
//     *     public ListNode next;
//     *     ListNode(int x) { val = x; next = null; }
//     * }
//     */
//
//        public ListNode solve(ListNode A) {
//            if(A.next==null) return null;
//            ListNode fast = A, slow = A, lastslow = A;
//            while(fast!=null && fast.next!=null){
//                lastslow = slow;
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            lastslow.next = lastslow.next.next;
//            return A;
//        }
//}
