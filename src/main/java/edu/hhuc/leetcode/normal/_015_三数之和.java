package edu.hhuc.leetcode.normal;

import java.util.*;
import java.util.stream.Collectors;

public class _015_三数之和 {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        _015_三数之和 instance = new _015_三数之和();
        System.out.println(instance.solution2(nums));
    }

    /**
     * 暴力枚举，时间复杂度为O(n^3)，同时需要去重，空间复杂度为O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> exists = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // 去除重复的元组
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        String combination = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
                        if (exists.add(combination)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 对solution1进行的优化
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 先排序，然后使用两个指针查找
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 去除重复的元组
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target > 0) {
                    right--;
                } else if (target < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去除重复的元组
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
