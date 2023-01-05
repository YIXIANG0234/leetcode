package edu.hhuc.leetcode.normal;

public class _198_打家劫舍 {
    public static void main(String[] args) {
        _198_打家劫舍 instance = new _198_打家劫舍();
        int[] nums = {1, 2, 3, 1};
        System.out.println(instance.solution2(nums));
    }

    /**
     * 动态规划dp[i]表示偷窃第i个屋子是偷到的最多的钱
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i], nums[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[length - 1];
    }

    /**
     * 动态规划，采用滚动数组，优化空间复杂度
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int first = nums[0];
        int second = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                second = Math.max(first, nums[i]);
            } else {
                int three = Math.max(first + nums[i], second);
                first = second;
                second = three;
            }
        }
        return Math.max(first, second);
    }

}
