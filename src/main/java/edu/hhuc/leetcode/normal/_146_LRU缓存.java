package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.LRUCache;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/16 15:22:49
 */
public class _146_LRU缓存 {
    // 实现参见LRUCache

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
}
