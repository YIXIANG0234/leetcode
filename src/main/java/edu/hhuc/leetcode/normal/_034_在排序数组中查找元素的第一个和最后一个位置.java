package edu.hhuc.leetcode.normal;

import java.util.Arrays;

public class _034_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        _034_在排序数组中查找元素的第一个和最后一个位置 instance = new _034_在排序数组中查找元素的第一个和最后一个位置();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = instance.solution1(nums, 8);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                int start = mid;
                int end = mid;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                while (end < nums.length && nums[end] == target) {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            }
        }
        return new int[]{-1, -1};
    }
}
