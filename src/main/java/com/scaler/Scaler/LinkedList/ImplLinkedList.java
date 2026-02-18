package com.scaler.Scaler.LinkedList;

public class ImplLinkedList {

    public static class Node{
        int val;
        Node next;
        public Node(int a){
            val = a;
            next = null;
        }
    }
    public static Node head = null;
    public static int length = 0;
    public static void insert_node(int position, int value) {
        if(position > length+1){
            return;
        }
        if(position == 1){
            Node n = new Node(value);
            n.next = head;
            head = n;
        }else{
            Node top = head;
            for(int i = 2; i <= position-1; i++){
                top = top.next;
            }
            Node n = new Node(value);
            n.next = top.next;
            top.next = n;
        }
        length++;
    }

    public static void delete_node(int position) {
        if(position > length){
            return;
        }
        if(position == 1){
            head = head.next;
        }else{
            Node top = head;
            for(int i = 2; i <= position-1; i++){
                top = top.next;
            }
            top.next = top.next.next;
        }
        length--;
    }

    public static void print_ll() {
        if(length == 0){
            return;
        }
        Node top = head;
        while(top.next != null){
            System.out.print(top.val+" ");
            top = top.next;
        }
        System.out.print(top.val);
    }
}
