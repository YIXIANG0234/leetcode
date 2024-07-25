package edu.hhuc.leetcode.normal;

import java.util.Arrays;

public class _034_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        _034_在排序数组中查找元素的第一个和最后一个位置 instance = new _034_在排序数组中查找元素的第一个和最后一个位置();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = instance.solution2(nums, 8);
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


    public int[] solution2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                return new int[]{left + 1, right - 1};
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
