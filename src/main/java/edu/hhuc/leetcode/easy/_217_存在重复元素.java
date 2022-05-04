package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _217_存在重复元素 {
    /**
     * hash表统计
     *
     * @param nums
     * @return
     */
    public boolean solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * 排序法
     * @param nums
     * @return
     */
    public boolean solution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
