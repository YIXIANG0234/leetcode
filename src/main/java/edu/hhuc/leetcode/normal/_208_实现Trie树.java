package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.Trie;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/19 11:21:47
 */
public class _208_实现Trie树 {
    // 实现参见Trie
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("catch");
        trie.insert("cat");
        trie.insert("catabolite");
        trie.insert("cate");
        trie.insert("dog");
        trie.insert("hike");
        trie.insert("hug");
        trie.insert("done");
        trie.insert("hi");
        trie.insert("hello");
        System.out.println(trie.match("cat"));
    }
}
