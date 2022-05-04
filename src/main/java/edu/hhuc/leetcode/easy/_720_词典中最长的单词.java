package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _720_词典中最长的单词 {
    public static void main(String[] args) {
        _720_词典中最长的单词 instance = new _720_词典中最长的单词();
        String[] words = new String[]{"w", "wo", "wor", "worl", "world"};
        System.out.println(instance.solution2(words));
    }

    /**
     * 排序
     *
     * @param words
     * @return
     */
    public String solution1(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return b.compareTo(a);
        });
        Set<String> set = new HashSet<>();
        set.add("");
        String longest = "";
        for (String word : words) {
            String prev = word.substring(0, word.length() - 1);
            if (set.contains(prev) && longest.length() < word.length()) {
                longest = word;
                set.add(word);
            }
        }
        return longest;
    }

    /**
     * 字典树
     *
     * @param words
     * @return
     */
    public String solution2(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (root.search(word)) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }
}
