package com.scaler.InterviewCodingQuestionPractice;
public class FlattenLinkedList {

     static class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
     this.data = 0;
     this.next = null;
     this.child = null;
     }
     Node(int data)
     {
     this.data = data;
     this.next = null;
     this.child = null;
     }
     Node(int data, Node next, Node child)
     {
     this.data = data;
     this.next = next;
     this.child = child;
     }
     }
     //TC:- n*n*log n
        public static Node flattenLinkedList(Node head) {
            //Write your code here
            if(head == null || head.next == null) return head;
            head.next = flattenLinkedList(head.next);
            head = merge(head,head.next);
            return head;

        }

        static Node merge(Node a, Node b){
            Node temp = new Node(0);
            Node res = temp;
            while(a!= null && b !=null){
                if(a.data < b.data){
                    temp.child = a;
                    temp = temp.child;
                    a = a.child;
                }else{
                    temp.child = b;
                    temp = temp.child;
                    b = b.child;
                }
            }
            if(a != null){
                temp.child = a;
            }else temp.child = b;

            return res.child;
        }

    Node flatten(Node root) {
        Node temp = root.next;
        while(temp!=null)
        {
            Node nextTemp = temp.next;
            merge2Nodes(root,temp);
            temp = nextTemp;
        }
        return root;
    }

    void merge2Nodes(Node node1,Node node2)
    {
        Node temp1 = node1;
        Node temp2 = node2;
        Node dN = new Node(-1);
        Node temp = dN;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.data > temp2.data)
            {
                temp.child = temp2;
                temp2 = temp2.child;
            }
            else
            {
                temp.child = temp1;
                temp1 = temp1.child;
            }
            temp = temp.child;
        }
        while(temp1 != null)
        {
            temp.child = temp1;
            temp1 = temp1.child;
            temp = temp.child;
        }
        while(temp2 != null)
        {
            temp.child = temp2;
            temp2 = temp2.child;
            temp = temp.child;
        }
        temp.child = null;
    }

        public static Node flattenLinkedListOptimize(Node head) {
            //Write your code here
            if(head==null || head.next==null) return head;
            Node ans=head;
            Node temp=head.next;
            ans.next=null;

            while(temp!=null){
                ans=mergeTwoLists(ans, temp);
                temp=temp.next;
            }
            return ans;
        }
        public static Node mergeTwoLists(Node a, Node b) {
            Node temp = new Node(0);
            Node res = temp;
            while(a != null && b != null) {
                if(a.data < b.data) {
                    temp.child = a;
                    temp = temp.child;
                    a = a.child;
                }
                else {
                    temp.child = b;
                    temp = temp.child;
                    b = b.child;
                }
            }
            if(a != null) temp.child = a;
            else temp.child = b;
            return res.child;
        }

}
