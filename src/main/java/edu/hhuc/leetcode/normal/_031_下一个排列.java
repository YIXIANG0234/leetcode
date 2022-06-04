package edu.hhuc.leetcode.normal;

import java.util.Arrays;

public class _031_下一个排列 {
    public static void main(String[] args) {
        _031_下一个排列 instance = new _031_下一个排列();
        int[] nums = {4, 5, 2, 6, 3, 1};
        instance.solution1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void solution1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
