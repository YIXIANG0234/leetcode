package edu.hhuc.leetcode.normal;

public class _055_跳跃游戏 {
    public static void main(String[] args) {
        _055_跳跃游戏 instance = new _055_跳跃游戏();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(instance.solution1(nums));
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public boolean solution1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        int length = nums.length;
        dp[0] = true;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            dp[i] = false;
            while (j >= 0) {
                if (dp[j] && nums[j] >= (i - j)) {
                    dp[i] = true;
                    break;
                }
                j--;
            }
        }
        return dp[length - 1];
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public boolean solution2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
