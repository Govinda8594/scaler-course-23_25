package com.scaler.InterviewCodingQuestionPractice;

public class MergeTwoSortedArrays {

    public static int[] ninjaAndSortedArrays(int[] arr1, int[] arr2, int m, int n) {
        // Write your code here.
        int[] ans = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] != 0 && arr2[j] != 0) {
                if (arr1[i] < arr2[j]) {
                    ans[k] = arr1[i];
                    i++;
                    k++;
                } else {
                    ans[k] = arr2[j];
                    j++;
                    k++;
                }
            }
        }
        while (j != n) {
            ans[k] = arr2[j];
            j++;
            k++;
        }

        while (i != m) {
            ans[k] = arr1[i];
            i++;
            k++;
        }
        return ans;
    }

//     Following is the linked list node structure:

    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        // Write your code here.

        if (first == null) return second;
        if (second == null) return first;
        LinkedListNode ans = null, temp = null;
        if (first.data <= second.data) {
            ans = first;
            temp = first;
            first = first.next;
        } else {
            ans = second;
            temp = second;
            second = second.next;
        }
        while (first != null && second != null) {
            if (first.data <= second.data) {
                temp.next = first;
                temp = temp.next;
                first = first.next;
            } else {
                temp.next = second;
                temp = temp.next;
                second = second.next;
            }
        }
        while (first != null) {
            temp.next = first;
            temp = temp.next;
            first = first.next;
        }
        while (second != null) {
            temp.next = second;
            temp = temp.next;
            second = second.next;
        }
        return ans;
    }

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

}
