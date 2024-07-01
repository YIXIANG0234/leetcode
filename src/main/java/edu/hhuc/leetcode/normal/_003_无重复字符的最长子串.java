package edu.hhuc.leetcode.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @ClassName _003_无重复字符的最长子串
 * @description:
 * @author: gaoya
 * @create: 2024-06-30 23:45
 * @Version 1.0
 */
public class _003_无重复字符的最长子串 {
    public static void main(String[] args) {
        _003_无重复字符的最长子串 instance = new _003_无重复字符的最长子串();
        System.out.println(instance.solution3("abcabcbb"));
    }

    /**
     * 暴力枚举
     *
     * @param s
     * @return
     */
    public int solution1(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> chars = new HashSet<>();
            int j = i;
            for (; j < s.length(); j++) {
                if (chars.contains(s.charAt(j))) {
                    break;
                }
                chars.add(s.charAt(j));
            }
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }

    /**
     * 针对solution1进行优化
     *
     * @param s
     * @return
     */
    public int solution2(String s) {
        int i = 0;
        int maxLength = 0;
        while (i < s.length()) {
            int j = i;
            Map<Character, Integer> chars = new HashMap<>();
            while (j < s.length()) {
                if (chars.containsKey(s.charAt(j))) {
                    // 直接跳过当前重复的字符，到下一个字符
                    maxLength = Math.max(maxLength, j - i);
                    i = chars.get(s.charAt(j)) + 1;
                    break;
                }
                chars.put(s.charAt(j), j);
                j++;
            }
            // 遍历到最后了，都没重复的，不用再枚举下一个字串了，因为后面的字串长度只会越来越小
            if (j == s.length()) {
                maxLength = Math.max(maxLength, j - i);
                break;
            }
        }
        return maxLength;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int solution3(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> chars = new HashSet<>();
        while (i < s.length()) {
            while (j < s.length()) {
                // 有重复元素时，将起点字符移除，即换下一个字符作为起点
                if (chars.contains(s.charAt(j))) {
                    chars.remove(s.charAt(i));
                    break;
                }
                chars.add(s.charAt(j));
                j++;
            }
            maxLength = Math.max(maxLength, j - i);
            i++;
        }
        return maxLength;
    }
}
