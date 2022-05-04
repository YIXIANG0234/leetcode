package edu.hhuc.leetcode.easy;

import java.util.Arrays;

public class _328_三个数的最大乘积 {
    public static void main(String[] args) {
        _328_三个数的最大乘积 instance = new _328_三个数的最大乘积();
        System.out.println(instance.solution2(new int[]{-2, -2, 9, 10, 11}));
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // nums[0] * nums[1] * nums[n - 1]是考虑有负数的情况
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    /**
     * 一次遍历，分别求得最小的两个数和最大的三个数
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        // min1最小，min2第二小
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // max1最大，max2次大，max3第三大
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            }

            if (nums[i] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] >= max3) {
                max3 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
