package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _389_找不同 {
    public static void main(String[] args) {
        _389_找不同 instance = new _389_找不同();
        System.out.println(instance.solution3("abcd", "abcde"));
    }

    /**
     * hash表
     *
     * @param s
     * @param t
     * @return
     */
    public char solution1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return ch;
            } else {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }
        return 'A';
    }

    /**
     * 数组代替hash表
     *
     * @param s
     * @param t
     * @return
     */
    public char solution2(String s, String t) {
        char[] count = new char[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            int index = ch - 'a';
            if (count[index] == 0) {
                return ch;
            } else {
                count[index]--;
            }
        }
        return 'A';
    }

    /**
     * 排序法
     *
     * @param s
     * @param t
     * @return
     */
    public char solution3(String s, String t) {
        char[] ch1 = s.toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch2);
        int index1 = 0;
        int index2 = 0;
        while (index1 < ch1.length && index2 < ch2.length) {
            if (ch1[index1] != ch2[index2]) {
                return ch2[index2];
            }
            index1++;
            index2++;
        }
        // 该字母添加到末尾了
        return ch2[index2];
    }

    /**
     * 求和
     *
     * @param s
     * @param t
     * @return
     */
    public char solution4(String s, String t) {
        int sum = 0;
        for (char ch : t.toCharArray()) {
            sum += ch;
        }
        for (char ch : s.toCharArray()) {
            sum -= ch;
        }
        return (char) sum;
    }

    /**
     * 异或算法
     *
     * @param s
     * @param t
     * @return
     */
    public char solution5(String s, String t) {
        int xor = 0;
        for (char ch : s.toCharArray()) {
            xor = xor ^ ch;
        }
        for (char ch : t.toCharArray()) {
            xor = xor ^ ch;
        }
        return (char) xor;
    }
}
