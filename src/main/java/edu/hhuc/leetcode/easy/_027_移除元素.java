package edu.hhuc.leetcode.easy;

import java.util.Arrays;

public class _027_移除元素 {
    public static void main(String[] args) {
        _027_移除元素 instance = new _027_移除元素();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        instance.solution1(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public int solution1(int[] nums, int val) {
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
                nums[index] = nums[i];
                index++;
            }
        }
        return count;
    }
}
