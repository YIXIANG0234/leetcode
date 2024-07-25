package edu.hhuc.leetcode.hard;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/14 16:21:02
 */
public class _076_最小覆盖子串 {
    public static void main(String[] args) {
        _076_最小覆盖子串 instance = new _076_最小覆盖子串();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(instance.solution1(s, t));
    }

    /**
     * 暴力枚举
     *
     * @param s
     * @param t
     * @return
     */
    public String solution1(String s, String t) {
        String max = s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length() - 1; j < s.length(); j++) {
                if (contains(s, i, j, t) && (j - i + 1) < max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
    }

    private boolean contains(String s, int i, int j, String t) {
        boolean[] checked = new boolean[j - i + 1];
        for (int index = 0; index < t.length(); index++) {
            int left = i;
            while (left <= j) {
                if (!checked[left - i] && t.charAt(index) == s.charAt(left)) {
                    checked[left - i] = true;
                    break;
                }
                left++;
            }
            if (left == j + 1) {
                return false;
            }
        }
        return true;
    }
}
