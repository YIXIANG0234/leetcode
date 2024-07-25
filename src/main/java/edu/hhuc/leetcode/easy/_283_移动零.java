package edu.hhuc.leetcode.easy;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/22 16:22:16
 */
public class _283_移动零 {
    public static void main(String[] args) {
        _283_移动零 instance = new _283_移动零();
        // int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {2, 1, 0, 3, 4, 0, 7, 0, 9, 11, 12};
        instance.solution2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 遍历数组，遇到0时，与它后面的第一个非0元素交换
     * 最坏时间复杂度O(n^2)
     *
     * @param nums
     */
    public void solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] != 0) {
                    break;
                }
                j++;
            }
            if (j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public void solution2(int[] nums) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

    }
}
