package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/16 17:00:30
 */
public class _152_乘积最大子数组 {
    public static void main(String[] args) {
        _152_乘积最大子数组 instance = new _152_乘积最大子数组();
        int[] nums = {1, 3, 4, 1, 2, -1, 6, 3};
        System.out.println(instance.solution3(nums));
    }

    public int solution1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                temp = temp * nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public int solution2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int solution3(int[] nums) {
        int len = nums.length;
        int prev = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            int temp = Math.max(prev * nums[i], nums[i]);
            max = Math.max(max, temp);
            prev = temp;
        }
        return max;
    }
}
