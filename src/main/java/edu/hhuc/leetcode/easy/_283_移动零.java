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
     * 类似冒泡排序，冒泡排序是稳定排序，每次将一个0移动到数组末尾
     * 最坏时间复杂度O(n^2)
     *
     * @param nums
     */
    public void solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void solution2(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    /**
     * 两次遍历
     *
     * @param nums
     */
    public void solution3(int[] nums) {
        int j = 0;
        // 先将所有非0元素移动到数组最左端
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        // 在数组右边补0
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}
