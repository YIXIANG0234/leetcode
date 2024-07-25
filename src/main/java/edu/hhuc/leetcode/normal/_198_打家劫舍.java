package edu.hhuc.leetcode.normal;

public class _198_打家劫舍 {
    public static void main(String[] args) {
        _198_打家劫舍 instance = new _198_打家劫舍();
        // int[] nums = {1, 2, 3, 1};
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(instance.solution5(nums));
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

    public int solution3(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 2; j < nums.length; j = j + 2) {
                sum = sum + nums[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int solution4(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i <= 1) {
                dp[i] = nums[i];
                continue;
            }
            dp[i] = dp[i - 2] + nums[i];
        }
        if (len == 1) {
            return dp[0];
        }

        return Math.max(dp[len - 1], dp[len - 2]);
    }

    public int solution5(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            prev1 = prev1 + nums[i];
            if (i+1<nums.length) {
                prev2 = prev2 + nums[i + 1];
            }
        }
        return Math.max(prev1, prev2);
    }
}
