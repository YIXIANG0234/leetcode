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
        LRUCache lru = new LRUCache(2);
        lru.put(1, 0);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        lru.get(2);
        lru.put(4, 4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
    }
}
