package edu.hhuc.leetcode.normal;

public class _053_最大子数组和 {
    public static void main(String[] args) {
        _053_最大子数组和 instance = new _053_最大子数组和();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(instance.solution1(nums));
    }

    /**
     * 时间和空间复杂度为O(n)
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    /**
     * 相比于solution1，其实不需要dp[i]数组，因为dp[i]的状态只依赖于前一个状态
     * 所以只需要使用一个额外的变量记住前一个状态即可，空间复杂度降为O(1)
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int maxSum = nums[0];
        // 上一个状态值，初始为0
        int prev = 0;
        for (int x : nums) {
            prev = Math.max(prev + x, x);
            maxSum = Math.max(maxSum, prev);
        }
        return maxSum;
    }

    public int solution3(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
