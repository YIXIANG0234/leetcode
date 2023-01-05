package edu.hhuc.leetcode.剑指Offer;

/**
 * @program: leetcode
 * @ClassName _058_左旋转字符串II
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 22:29
 * @Version 1.0
 */
public class _058_左旋转字符串II {
    public String reverseLeftWords(String s, int n) {
        if (n == s.length()) {
            return s;
        }
        char[] chars = new char[s.length()];
        int index = 0;
        int length = s.length();
        for (int i = n; i < s.length() + n; i++) {
            chars[index++] = s.charAt(i % length);
        }
        return new String(chars, 0, length);
    }
}
