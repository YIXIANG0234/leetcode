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

    /**
     * hash表解法
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLength = 0;
        for (int num : set) {
            // 如果num-1存在，则这个连续的序列会以num-1为起点统计，为num的时候不用重复统计了
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] - nums[i - 1] == 1) {
                count++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                maxLength = Math.max(maxLength, count);
                count = 1;
            }
        }
        return Math.max(maxLength, count);
    }
}
