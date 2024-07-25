package edu.hhuc.leetcode.normal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/15 22:06:11
 */
public class _128_最长连续序列 {
    public static void main(String[] args) {
        _128_最长连续序列 instance = new _128_最长连续序列();
        int[] nums = {400, 1, 100, 3, 4, 2};
        // int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(instance.solution2(nums));
    }

    public int solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int length = 0;
            while (set.contains(num)) {
                length++;
                num++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public int solution2(int[] nums) {
        int maxLength = 0;
        int length = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                maxLength = Math.max(maxLength, length);
                length = 1;
            } else {
                length++;
            }
        }
        maxLength = Math.max(maxLength, length);
        return maxLength;
    }
}
