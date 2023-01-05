package edu.hhuc.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _387_字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        _387_字符串中的第一个唯一字符 instance = new _387_字符串中的第一个唯一字符();
        System.out.println(instance.solution2("leetcode"));
    }

    public int solution1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 题目说明只包含小写字母，可以用一个数组来保存元素出现的次数
     *
     * @param s
     * @return
     */
    public int solution2(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            frequency[index] = frequency[index] + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
