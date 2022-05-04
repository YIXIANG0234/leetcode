package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _645_错误的集合 {
    public static void main(String[] args) {
        _645_错误的集合 instance = new _645_错误的集合();
        System.out.println(Arrays.toString(instance.solution2(new int[]{2, 3, 3, 4, 5, 6})));
    }

    public int[] solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        int[] result = new int[2];
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i) && map.get(i) > 1) {
                result[0] = i;
            }
            if (!map.containsKey(i)) {
                result[1] = i;
            }
        }
        return result;
    }

    /**
     * 排序法
     *
     * @param nums
     * @return
     */
    public int[] solution2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] result = new int[2];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                result[0] = nums[i];
            }
            if (nums[i + 1] - nums[i] > 1) {
                result[1] = nums[i] + 1;
            }
        }
        // 处理缺失头部的情况
        if (nums[0] != 1) {
            result[1] = 1;
        }
        // 处理缺失尾部的情况
        if (nums[n - 1] != n) {
            result[1] = n;
        }
        return result;
    }
}
