package edu.hhuc.leetcode.normal;

import java.util.Stack;

public class _739_每日温度 {
    /**
     * 暴力枚举
     * @param temperatures
     * @return
     */
    public int[] solution1(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int today = temperatures[i];
            for (int j = i + 1; j < length; j++) {
                int after = temperatures[j];
                if (after > today) {
                    answer[i] = j - i;
                    break;
                }
            }
            if (i == length - 1) {
                answer[i] = 0;
            }
        }
        return answer;
    }

    /**
     * 单调栈
     * @param temperatures
     * @return
     */
    public int[] solution2(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int prev = stack.pop();
            answer[prev] = 0;
        }
        return answer;
    }
}
