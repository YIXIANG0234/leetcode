package edu.hhuc.leetcode.normal;

import java.util.Arrays;

public class _016_最接近的三数之和 {
    public static void main(String[] args) {
        _016_最接近的三数之和 instance = new _016_最接近的三数之和();
        instance.solution1(new int[]{-3,-2,-5,3,-4}, -1);
    }

    /**
     * 排序+双指针
     * @param nums
     * @param target
     * @return
     */
    public int solution1(int[] nums, int target) {
        Arrays.sort(nums);
        long result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
                if (sum == target) {
                    return (int)result;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return (int)result;
    }
}
