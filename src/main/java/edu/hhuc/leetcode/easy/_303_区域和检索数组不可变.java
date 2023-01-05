package edu.hhuc.leetcode.easy;

public class _303_区域和检索数组不可变 {
    private int[] nums;

    public _303_区域和检索数组不可变(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        left = Math.max(left, 0);
        right = Math.min(right, nums.length - 1);
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
