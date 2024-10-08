package edu.hhuc.leetcode.normal;

public class _198_打家劫舍 {
    public static void main(String[] args) {
        _198_打家劫舍 instance = new _198_打家劫舍();
        int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
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
     * 回溯，会超时
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        return backtrace(nums, 0, 0);
    }

    private int backtrace(int[] nums, int index, int sum) {
        if (index >= nums.length) {
            return sum;
        }
        return Math.max(backtrace(nums, index + 2, sum + nums[index]), backtrace(nums, index + 1, sum));
    }
}
