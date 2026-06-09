package com.scaler.Scaler.LinkedList;

public class NearestMultipleOfB {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    static void nearestMultiple(Node head, int B) {
        for (Node temp = head; temp != null; temp = temp.next) {
            temp.data = temp.data % B > B / 2 ? (int) Math.ceil((double) temp.data / (double) (B + 1)) * B :
                        (int) Math.ceil((double) temp.data / (double) B) * B;
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(5);
        int B = 3;
        nearestMultiple(head, B);
        printList(head);
    }
}
