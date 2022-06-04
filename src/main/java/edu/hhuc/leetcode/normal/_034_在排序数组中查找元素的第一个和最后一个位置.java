package edu.hhuc.leetcode.normal;

import java.util.Arrays;

public class _034_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        _034_在排序数组中查找元素的第一个和最后一个位置 instance = new _034_在排序数组中查找元素的第一个和最后一个位置();
        int[] nums = {1};
        int[] result = instance.solution1(nums, 1);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution1(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int i = mid - 1;
                int j = mid + 1;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                while (j <= nums.length - 1 && nums[j] == target) {
                    j++;
                }
                result[0] = i + 1;
                result[1] = j - 1;
                break;
            }

        }
        return result;
    }
}
