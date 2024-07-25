package edu.hhuc.leetcode.hard;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/10 20:10:32
 */
public class _032_最长的有效括号 {

    public static void main(String[] args) {
        _032_最长的有效括号 instance = new _032_最长的有效括号();
        String s = "(())((())))()()()()";
        System.out.println(instance.solution1(s));
    }

    /**
     * 暴力解法
     * @param s
     * @return
     */
    public int solution1(String s) {
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (valid(s, i, j) && (j - i) > (right - left)) {
                    left = i;
                    right = j;
                }
            }
        }
        if (left == -1) {
            return 0;
        }
        System.out.println(s.substring(left, right + 1));
        return (right - left + 1);
    }

    public int solution2(String s) {
        int count = 0;
        while (!s.isEmpty()) {
            s = s.replace("()", "");
        }
        return count;
    }

    public boolean valid(String s, int left, int right) {
        int balance = 0;
        while (left <= right) {
            if (s.charAt(left) == '(') {
                balance++;
            }
            if (s.charAt(left) == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
            left++;
        }
        return balance == 0;
    }
}
