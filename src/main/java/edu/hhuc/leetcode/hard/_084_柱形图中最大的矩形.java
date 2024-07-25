package edu.hhuc.leetcode.hard;

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
     * @param heights
     * @return
     */
    public int solution1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = (j - i + 1) * min;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}
