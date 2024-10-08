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
        System.out.println(instance.solution2(nums));
    }

    /**
     * 暴力枚举
     *
     * @param nums
     * @return
     */
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

    /**
     * 动态规划
     * 1.定义两个数组，分别存储以当前位置i为结尾的子数组的最大乘积和最小乘积
     * 2.计算当前位置最大乘积的方法，分类讨论
     * 1.当num[i]>=0时，maxDP[i] = max(maxDP[i-1]*nums[i], nums[i])
     * 2.当num[i]<0时，maxDP[i] = max(minDP[i-1]*nums[i], nums[i])
     * 3.综上，计算当前位置最大乘积，只需要计算maxDP[i-1]*nums[i]，minDP[i-1]*nums[i]，nums[i]，取三者最大值即可
     * 3.计算当前位置最小乘积的方法，分类讨论
     * 1.当nums[i]>=0时，minDP[i] = min(minDP[i-1]*nums[i], nums[i])
     * 2.当nums[i]<0时，minDP[i] = min(maxDP[i-1]*nums[i], nums[i])
     * 3.综上，计算当前位置最小乘积，只需要计算maxDP[i-1]*nums[i]，minDP[i-1]*nums[i]，nums[i]，取三者最小值即可
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int len = nums.length;
        int[] minDP = new int[len];
        int[] maxDP = new int[len];
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                minDP[i] = nums[i];
                maxDP[i] = nums[i];
                continue;
            }
            maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(minDP[i - 1] * nums[i], nums[i]));
            minDP[i] = Math.min(maxDP[i - 1] * nums[i], Math.min(minDP[i - 1] * nums[i], nums[i]));
            max = Math.max(max, maxDP[i]);
        }
        return max;
    }
}
