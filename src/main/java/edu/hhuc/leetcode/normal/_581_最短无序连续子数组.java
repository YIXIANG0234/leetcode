package edu.hhuc.leetcode.normal;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/24 20:21:19
 */
public class _581_最短无序连续子数组 {
    public static void main(String[] args) {
        // int[] nums = {2, 6, 4, 8, 10, 9, 15};
        // int[] nums = {1, 3, 2, 4, 5, 8, 7};
        int[] nums = {1, 2, 3, 4, 5};
        _581_最短无序连续子数组 instance = new _581_最短无序连续子数组();
        System.out.println(instance.solution2(nums));
    }

    public int solution1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        // 找到所有的逆序对（a,b)，计算最后一个逆序对b的下标和第一个逆序对a的下标的差值
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                min = Math.min(min, i);
                max = Math.max(max, i + 1);
            }
        }
        return max == -1 ? 0 : max - min + 1;
    }

    public int solution2(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right && arr[left] == nums[left]) {
            left++;
        }
        while (right >= left && arr[right] == nums[right]) {
            right--;
        }

        return right - left + 1;
    }
}
