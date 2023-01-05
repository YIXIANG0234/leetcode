package edu.hhuc.leetcode.面试题;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: leetcode
 * @ClassName 面试题_16_25_LRU缓存
 * @description:
 * @author: gaoya
 * @create: 2022-12-02 11:14
 * @Version 1.0
 */
public class 面试题_16_25_LRU缓存 {
    private int capacity;
    private Map<Integer, CacheNode> cache;
    private CacheNode head;
    private CacheNode tail;

    public 面试题_16_25_LRU缓存(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        CacheNode node = cache.get(key);
        if (Objects.isNull(node)) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        CacheNode node = cache.get(key);
        if (Objects.nonNull(node)) {
            node.value = value;
            moveToHead(node);
            return;
        }
        CacheNode newNode = new CacheNode(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
        if (cache.size() > capacity) {
            CacheNode removed = removeTail();
            cache.remove(removed.key);
        }
    }

    private void addToHead(CacheNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private CacheNode removeTail() {
        CacheNode removed = tail.prev;

        removed.prev.next = tail;
        tail.prev = removed.prev;

        removed.prev=null;
        removed.next = null;
        return removed;
    }

    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(CacheNode node) {
        removeNode(node);
        addToHead(node);
    }

    class CacheNode {
        public CacheNode() {
        }

        public CacheNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        CacheNode prev;
        CacheNode next;
        Integer key;
        Integer value;
    }
}
