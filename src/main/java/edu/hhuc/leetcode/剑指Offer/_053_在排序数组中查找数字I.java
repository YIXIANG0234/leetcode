package edu.hhuc.leetcode.剑指Offer;

/**
 * @program: leetcode
 * @ClassName _053_在排序数组中查找数字I
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 23:03
 * @Version 1.0
 */
public class _053_在排序数组中查找数字I {
    public static void main(String[] args) {
        _053_在排序数组中查找数字I instance = new _053_在排序数组中查找数字I();
        System.out.println(instance.search2(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[mid] == target) {
            count++;
            int index = mid - 1;
            while (index >= 0 && nums[index] == target) {
                count++;
                index--;
            }
            index = mid + 1;
            while (index < nums.length && nums[index] == target) {
                count++;
                index++;
            }
        }
        return count;
    }

    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public int helper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
