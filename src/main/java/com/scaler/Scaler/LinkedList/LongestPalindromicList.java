package com.scaler.Scaler.LinkedList;

//Given a linked list of integers.
// Find and return the length of the longest palindrome list that exists in that linked list.
//        A palindrome list is a list that reads the same backward and forward.
//        Expected memory complexity : O(1)
public class LongestPalindromicList {

    public int solve(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        int ans = 0;
        while (curr != null) {
            // reverse the list
            ListNode next = curr.next;
            curr.next = prev;
            // calculate for even length list
            ans = Math.max(ans, 2 * checkpalindromlength(curr, next));
            // calculate for odd length list
            ans = Math.max(ans, 2 * checkpalindromlength(prev, next) + 1);
            // update prev and curr
            prev = curr;
            curr = next;
        }
        return ans;
    }

    private int checkpalindromlength(ListNode A, ListNode B) {
        int num = 0;
        while (A != null && B != null) {
            if (A.val != B.val) {
                break;
            }
            num++;
            A = A.next;
            B = B.next;
        }
        return num;
    }
}
