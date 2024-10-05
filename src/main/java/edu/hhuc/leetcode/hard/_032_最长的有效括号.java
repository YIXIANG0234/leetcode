package edu.hhuc.leetcode.hard;

import java.util.Stack;

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
        System.out.println(instance.solution2(s));
    }

    /**
     * 暴力解法
     *
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
        return (right - left + 1);
    }

    /**
     * 栈的解法
     *
     * @param s
     * @return
     */
    public int solution2(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    } else {
                        maxLength = Math.max(maxLength, i + 1);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }

    /**
     * 标记法，先遍历字符串，将合法的括号的位置都标记为1，最后统计最大连续1的个数即为结果
     *
     * @param s
     * @return
     */
    public int solution3(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] flags = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            if (!stack.isEmpty()) {
                int top = stack.pop();
                flags[top] = 1;
                flags[i] = 1;
            }
        }
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    private boolean valid(String s, int left, int right) {
        int balance = 0;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
