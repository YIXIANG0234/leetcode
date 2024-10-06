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
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
            // 到不了当前节点，则也到不了最后一个节点了
            if (!dp[i]) {
                return false;
            }
        }
        return dp[nums.length - 1];
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
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 回溯，会超时啊
     *
     * @param nums
     * @return
     */
    public boolean solution3(int[] nums) {
        return backtrace(nums, 0);
    }

    private boolean backtrace(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }
        int step = nums[index];
        for (int i = 1; i <= step; i++) {
            if (backtrace(nums, index + i)) {
                return true;
            }
        }
        return false;
    }
}
