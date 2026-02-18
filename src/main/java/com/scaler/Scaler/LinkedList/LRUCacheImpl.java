package com.scaler.Scaler.LinkedList;

import java.util.HashMap;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
//        The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
//
//        Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
//        NOTE: If you are using any global variables, make sure to clear them in the constructor.


public class LRUCacheImpl {

    // create head and tail dummy nodes to avoid several edge cases
    int size = 0;
    HashMap<Integer, Node> hm;
    Node head, tail;
    public LRUCacheImpl(int capacity) {
        size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
    }

    public int getLRU(int key) {
        if (hm.get(key) == null) return -1;
        Node node = hm.get(key);
        // these two  lines for latest acesses so that it moved to tail side
        deleteNode(node);
        insertNode(node);
        return node.value;

    }

    public void setLRU(int key, int value) {
        if (hm.get(key) == null) {
            if (hm.size() == size) {
                // key  point is 1st remove from hashmap then from ll other wise it may lost
                Node temp = head.next;
                hm.remove(temp.key);
                deleteNode(head.next);
            }
            Node node = new Node(key, value);
            insertNode(node);
            hm.put(key, node);
        } else { //if already present in the cache
            Node node = hm.get(key);
            deleteNode(node);
            // add the latest value to tghe key and insert to first
            node.value = value;
            insertNode(node);
        }

    }

    public void insertNode(Node node) {
        // always insert at tail end
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // free the node
        node.prev = null;
        node.next = null;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int x, int y) {
            this.key = x;
            this.value = y;
        }
    }

}
