package com.scaler.Scaler.LinkedList;

public class ReverseLinkedListFromBToC {

    /////////////////////////////////iterative
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode temp1 = null;
        ListNode temp2 = A;
        int i = 1;
        while (i < B) {
            temp1 = temp2;   // pointer just before B
            temp2 = temp2.next;   // Bth pointer
            i++;
        }
        ListNode cur = temp2;
        ListNode pre = null;
        while (B <= C) {     //reverse logic between B & C
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            B++;
        }
        if (temp1 != null) {   //some elements are present before B
            temp1.next = pre;
        } else {        // no element efore B
            A = pre;
        }
        temp2.next = cur;
        return A;
    }

    //////////////////////////////Recusrion///////////////////////////////////////////////////////////////////
    public ListNode reverseBetween2(ListNode A, int m, int n) {
        int i;
        ListNode node = A;
        ListNode prev = null;
        m--;
        n--;
        for (i = 0; i < m; i++) {
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = reverseList(node, n - m + 1);
        else
            A = reverseList(node, n - m + 1);
        return A;
    }

    public ListNode reverseList(ListNode A, int count) {
        ListNode prev = null, firstNode = A;
        ListNode curr;
        while (A != null && count > 0) {
            curr = A;
            A = A.next;
            curr.next = prev;
            prev = curr;
            count--;
        }
        firstNode.next = A;
        return prev;
    }

//    public ListNode reverseList(ListNode A, int count) {
//        ListNode node, prev, temp, last;
//        node = A;
//        last = A;
//        if (node == null)
//            return null;
//        prev = null;
//        while (node != null && count > 0) {
//            temp = node.next;
//            node.next = prev;
//            prev = node;
//            node = temp;
//            count--;
//        }
//        last.next = node;
//        return prev;
//    }


}
