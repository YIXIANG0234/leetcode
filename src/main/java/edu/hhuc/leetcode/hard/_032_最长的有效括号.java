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
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isValid(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
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
            // 左括号下标入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 发现匹配的右括号
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        // 这种是某一段括号有效
                        maxLength = Math.max(maxLength, i - stack.peek());
                    } else {
                        // 这是从头到i的位置都有效
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

    private boolean isValid(String s, int left, int right) {
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

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int solution4(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 处理这种类型的括号: ...()
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else {
                    // 处理这种类型的括号: ((...))
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        // 这里加的是这一部分((...))
                        dp[i] = dp[i - 1] + 2;
                        // 这里加的是...((...))，因为((...))前面可能还有有效的括号，需要把这部分加上
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
}
