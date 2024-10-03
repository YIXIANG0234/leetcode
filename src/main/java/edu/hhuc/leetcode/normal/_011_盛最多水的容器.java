package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _011_盛最多水的容器
 * @description:
 * @author: gaoya
 * @create: 2024-10-03 19:40
 * @Version 1.0
 */
public class _011_盛最多水的容器 {
    public static void main(String[] args) {
        _011_盛最多水的容器 instance = new _011_盛最多水的容器();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(instance.solution1(height));
    }

    /**
     * 暴力枚举
     *
     * @param height
     * @return
     */
    public int solution1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int solution2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
