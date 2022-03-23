package edu.hhuc.leetcode.easy;

public class _704_二分查找 {
    /**
     * 迭代实现
     * @param nums
     * @param target
     * @return
     */
    public int solution1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
