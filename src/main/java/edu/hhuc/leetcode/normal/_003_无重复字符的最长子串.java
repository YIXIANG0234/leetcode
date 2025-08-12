package edu.hhuc.leetcode.normal;

import java.util.HashSet;
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
        System.out.println(instance.solution2("abcabcbb"));
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
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    break;
                }
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }

    /**
     * 双指针解法，分别枚举子串的左边界和右边界
     * 当没有重复字符的时候，一直扩展右边界
     * 当出现重复 字符的时候，向右调整左边界
     *
     * @param s
     * @return
     */
    public int solution2(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
