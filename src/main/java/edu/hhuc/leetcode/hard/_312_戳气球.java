package edu.hhuc.leetcode.hard;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/22 21:00:50
 */
public class _312_戳气球 {
    public static void main(String[] args) {
        _312_戳气球 instance = new _312_戳气球();
        int[] nums = {3, 1, 5, 8};
        System.out.println(instance.solution1(nums));
    }

    /**
     * 不对不对
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = len > 1 ? nums[0] * nums[1] : nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int prev = i > 1 ? nums[i - 2] : 1;
            int post = i + 1 < len ? nums[i + 1] : 1;
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i - 1] * nums[i] * post, dp[i - 1][1] + prev * nums[i] * post);
        }
        return dp[len - 1][1];
    }
}
