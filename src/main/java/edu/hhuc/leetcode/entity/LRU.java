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
public class LRU {
    public static void main(String[] args) {
        LRU lru = new LRU(5);
        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        lru.put("4", 4);
        lru.put("5", 5);

        lru.put("6", 6);
        lru.get("3");
        lru.put("7", 7);

        lru.get("5");
        lru.put("8", 8);
    }

    private int capacity;
    private int size;
    private final Map<String, ListNode> cache = new HashMap<>();
    ListNode head = null;
    ListNode tail = null;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public void put(String key, int value) {
        ListNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
            return;
        }
        node = new ListNode(value);
        cache.put(key, node);
        node.next = head;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head = node;
        }
        if (size == capacity) {
            ListNode removed = removeTail();
            cache.remove(removed.val + "");
        } else {
            size++;
        }
        ListNode.printLinkedList(head);
    }

    public int get(String key) {
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
        ListNode removedNode = tail;
        tail = current;
        current.next = null;
        return removedNode;
    }
}
