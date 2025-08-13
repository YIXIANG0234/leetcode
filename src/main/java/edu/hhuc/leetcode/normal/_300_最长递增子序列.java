package edu.hhuc.leetcode.normal;

public class _300_最长递增子序列 {
    public static void main(String[] args) {
        _300_最长递增子序列 instance = new _300_最长递增子序列();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(instance.solution1(nums));

    }

    /**
     * 动态规划，dp[i]表示以下标为i的位置最长的递增序列
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int maxLength = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
