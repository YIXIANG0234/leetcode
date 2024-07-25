package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/16 13:59:08
 */
public class _136_只出现一次的数字 {
    public static void main(String[] args) {
        _136_只出现一次的数字 instance = new _136_只出现一次的数字();
        int[] nums = {2, 2, 1};
        // int[] nums = {4, 1, 2, 1, 2};
        System.out.println(instance.solution3(nums));
    }

    public int solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int solution2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                i = i + 2;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int solution3(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
