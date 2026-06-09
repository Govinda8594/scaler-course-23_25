package com.scaler.Scaler.LinkedList;

import java.util.HashMap;

public class CloneDoublyLinkedListWithRandom {

    RandomDoublyLinkedList cloneList(RandomDoublyLinkedList h1) {
        RandomDoublyLinkedList t1 = h1;
        while (t1 != null) {
            RandomDoublyLinkedList newNode = new RandomDoublyLinkedList(h1.val);
            newNode.next = t1.next;
            t1.next = newNode;
            t1 = t1.next;
        }
        t1 = h1;
        RandomDoublyLinkedList h2 = h1.next;
        RandomDoublyLinkedList t2 = h2;
        while (t1 != null) {
            t2.random = t1.random.next;
            t1 = t2.next;
            if (t1 == null) {
                break;
            }
            t2 = t1.next;
        }
        t1 = h1;
        t2 = h2;
        while (t1 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if (t1 == null) {
                break;
            }
            t2.next = t1.next;
            t2 = t2.next;
        }
        return h2;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    RandomDoublyLinkedList cloneList2(RandomDoublyLinkedList h1) {
        if (h1 == null) {
            return h1;
        }
        RandomDoublyLinkedList h2 = new RandomDoublyLinkedList(h1.val);
        RandomDoublyLinkedList t1 = h1;
        RandomDoublyLinkedList t2 = h2;
        while (t1 != null) {
            RandomDoublyLinkedList newNode = new RandomDoublyLinkedList(t1.val);
            t2.next = newNode;
            t2 = newNode;
            t1 = t1.next;
        }
        RandomDoublyLinkedList temp1 = h1;
        RandomDoublyLinkedList temp2 = h2;
        HashMap<RandomDoublyLinkedList, RandomDoublyLinkedList> map = new HashMap<>();
        while (temp1 != null) {
            map.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        t1 = h1;
        t2 = h2;
        while (t1 != null) {
            t2.random = map.get(t1.random);
            t1 = t1.next;
            t2 = t2.next;
        }
        return h2;
    }

    class RandomDoublyLinkedList {
        int val;
        RandomDoublyLinkedList next, random;

        RandomDoublyLinkedList(int x) {
            val = x;
            next = random = null;
        }
    }
}


