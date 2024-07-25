package edu.hhuc.leetcode.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/11 15:31:51
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(5);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);

        lru.put(6, 6);
        lru.get(3);
        lru.put(7, 7);

        lru.get(5);
        lru.put(8, 8);
    }

    private int capacity;
    private int size;
    private Map<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
            return;
        }
        node = new ListNode(value);
        cache.put(key, node);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        if (size == capacity) {
            ListNode removed = removeTail();
            cache.remove(removed.val);
        } else {
            size++;
        }
        ListNode.printLinkedList(head);
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(ListNode node) {
        ListNode current = head;
        while (current.next != node) {
            current = current.next;
        }
        current.next = node.next;
        node.next = head;
        head = node;
        ListNode.printLinkedList(head);
    }

    private ListNode removeTail() {
        ListNode current = head;
        while (current.next != tail) {
            current = current.next;
        }
        ListNode node = tail;
        current.next = null;
        tail = current;
        return node;
    }
}
