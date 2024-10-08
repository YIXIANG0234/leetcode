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
    private int capacity;
    private int size;
    private Map<Integer, DoubleLinkedNode> cache;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new DoubleLinkedNode(-1, -1);
        this.tail = new DoubleLinkedNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = this.cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
        addToHead(newNode);
        cache.put(key, newNode);
        size++;
        if (size > this.capacity) {
            DoubleLinkedNode tailNode = removeTail();
            this.cache.remove(tailNode.key);
            size--;
        }
    }


    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;

        node.prev = null;
        node.next = null;
        return node;
    }

    private void addToHead(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        addToHead(node);
    }


    private class DoubleLinkedNode {
        private int key;
        private int value;
        private DoubleLinkedNode prev;
        private DoubleLinkedNode next;

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
