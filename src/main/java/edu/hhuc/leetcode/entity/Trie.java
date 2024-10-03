package edu.hhuc.leetcode.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trie {
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
        System.out.println(trie.match("hi"));
    }

    private Trie[] children;
    boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = innerSearch(word);
        return Objects.nonNull(node) && node.isEnd;
    }

    public boolean startWith(String prefix) {
        Trie node = innerSearch(prefix);
        return Objects.nonNull(node);
    }

    public List<String> match(String prefix) {
        List<String> result = new ArrayList<>();
        Trie node = innerSearch(prefix);
        if (node == null) {
            return result;
        }
        backtrace(node, new StringBuilder(prefix), result);
        return result;
    }

    private Trie innerSearch(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    private void backtrace(Trie node, StringBuilder sb, List<String> result) {
        if (node.isEnd) {
            result.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                backtrace(node.children[i], sb.append((char) (i + 'a')), result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
