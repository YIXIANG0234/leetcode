package edu.hhuc.leetcode.normal;

public class _300_最长递增子序列 {
    public static void main(String[] args) {
        _300_最长递增子序列 instance = new _300_最长递增子序列();
        int[] nums = {10, 1, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(instance.solution1(nums));

    }

    public int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
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
