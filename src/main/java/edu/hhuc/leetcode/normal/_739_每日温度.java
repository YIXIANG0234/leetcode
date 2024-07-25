package edu.hhuc.leetcode.normal;

import java.util.Arrays;
import java.util.Stack;

public class _739_每日温度 {
    public static void main(String[] args) {
        _739_每日温度 instance = new _739_每日温度();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        // 1,1,4,2,1,1,0,0
        System.out.println(Arrays.toString(instance.solution1(temperatures)));
    }

    /**
     * 暴力枚举
     *
     * @param temperatures
     * @return
     */
    public int[] solution1(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * 单调栈
     *
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
