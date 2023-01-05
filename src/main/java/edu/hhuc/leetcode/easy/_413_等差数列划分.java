package edu.hhuc.leetcode.easy;

import java.util.Arrays;

public class _413_等差数列划分 {
    public static void main(String[] args) {
        _413_等差数列划分 instance = new _413_等差数列划分();
        System.out.println(instance.solution1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
    }

    /**
     * 动态规划，dp[i]定义为，以位置i结尾的区间0-i中，等差子数组的个数
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 2; i < length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }

    /**
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int d = nums[i + 1] - nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j + 1] - nums[j] == d) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

}
