package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _242_有效的字母异位词 {
    public static void main(String[] args) {
        _242_有效的字母异位词 instance = new _242_有效的字母异位词();
        String s1 = "aa";
        String s2 = "aaa";
        System.out.println(instance.solution3(s1, s2));
    }

    /**
     * 解法与solution3相同
     * @param s
     * @param t
     * @return
     */
    public boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序后比较
     *
     * @param s
     * @param t
     * @return
     */
    public boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    /**
     * 数组实现的hash表
     * @param s
     * @param t
     * @return
     */
    public boolean solution3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        int index;
        for (int i = 0; i < t.length(); i++) {
            index = t.charAt(i) - 'a';
            table[index]--;
            if (table[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
