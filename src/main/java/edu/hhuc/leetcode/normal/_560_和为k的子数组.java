package edu.hhuc.leetcode.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/24 11:26:37
 */
public class _560_和为k的子数组 {

    public static void main(String[] args) {
        _560_和为k的子数组 instance = new _560_和为k的子数组();
        int[] nums = {1, 2, 3, 4, 0, 3, 0, 2, 0, 8};
        int k = 10;
        System.out.println(instance.solution1(nums, k));
    }

    public int solution1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和怎么做呢？
     * @param nums
     * @param k
     * @return
     */
    public int solution2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return 0;
    }
}
