package edu.hhuc.leetcode.hard;

import java.util.Stack;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/14 21:34:14
 */
public class _084_柱形图中最大的矩形 {
    public static void main(String[] args) {
        _084_柱形图中最大的矩形 instance = new _084_柱形图中最大的矩形();
        int[] heights = {2, 1, 2, 6, 2, 3};
        System.out.println(instance.solution1(heights));
    }

    /**
     * 暴力枚举
     *
     * @param heights
     * @return
     */
    public int solution1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = (j - i + 1) * minHeight;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int solution2(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < heights.length && heights[right] >= heights[i]) {
                right++;
            }
            int area = heights[i] * (right - left - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    /**
     * 单调栈解法
     * @param heights
     * @return
     */
    public int solution3(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(height * width, maxArea);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(height * width, maxArea);
        }
        return maxArea;
    }


}
