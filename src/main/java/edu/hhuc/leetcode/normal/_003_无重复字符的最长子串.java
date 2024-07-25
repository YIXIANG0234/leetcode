package edu.hhuc.leetcode.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/6/30 14:26:52
 */
public class _003_无重复字符的最长子串 {

    public static void main(String[] args) {
        _003_无重复字符的最长子串 instance = new _003_无重复字符的最长子串();
        System.out.println(instance.solution2("aabcdefhbgct"));
    }

    public int solution1(String s) {
        int i = 0;
        int maxLength = 0;
        // 以当前字符串的每个字符作为起点，查询不重复的子串
        while (i < s.length()) {
            Map<Character, Integer> chars = new HashMap<>();
            int j = i;
            for (; j < s.length(); j++) {
                if (chars.containsKey(s.charAt(j))) {
                    maxLength = Math.max(maxLength, j - i);
                    i = chars.get(s.charAt(j)) + 1;
                    break;
                }
                chars.put(s.charAt(j), j);
            }
            // 当前轮次遍历到了结尾没有重复字符，表明后续的轮次已经不可能比当前轮次长了，直接结束
            if (j == s.length()) {
                maxLength = Math.max(maxLength, j - i);
                break;
            }
        }
        return maxLength;
    }

    public int solution2(String s) {
        int j = 0;
        int maxLength = 0;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (chars.contains(s.charAt(j))) {
                    chars.remove(s.charAt(i));
                    break;
                } else {
                    chars.add(s.charAt(j));
                    j++;
                }
            }
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }
}
