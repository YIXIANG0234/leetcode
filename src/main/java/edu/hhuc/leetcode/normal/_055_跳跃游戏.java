package edu.hhuc.leetcode.normal;

public class _055_跳跃游戏 {
    public static void main(String[] args) {
        _055_跳跃游戏 instance = new _055_跳跃游戏();
        // int[] nums = {2, 3, 1, 1, 1};
        int[] nums = {3, 2, 1, 0, 4};
        // int[] nums = {1, 0, 1, 3, 2, 1, 4, 6};
        System.out.println(instance.solution5(nums));
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
        // 表示能到的最远的位置
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前位置在最远的位置之前，更新maxIndex
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public boolean solution3(int[] nums) {
        return test(nums, 0);
    }

    /**
     * 这个搞法估计不行哦
     *
     * @param nums
     * @return
     */
    public boolean solution4(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            int gap = len - 1 - i;
            if (nums[i] >= gap || (dp[i + 1] && nums[i] >= 1)) {
                dp[i] = true;
            }
        }
        return dp[0];
    }

    public boolean test(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }
        for (int i = nums[index]; i > 0; i--) {
            if (test(nums, index + i)) {
                return true;
            }
        }
        return false;
    }

    public boolean solution5(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
