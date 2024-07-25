package edu.hhuc.leetcode.normal;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class _015_三数之和 {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        _015_三数之和 instance = new _015_三数之和();
        System.out.println(instance.solution3(nums));
    }

    /**
     * 暴力枚举，性能有问题
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> exists = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Lists.newArrayList(nums[i], nums[j], nums[k]);
                        String s = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
                        if (!exists.contains(s)) {
                            exists.add(s);
                            result.add(list);
                        }
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
    public List<List<Integer>> solution2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 去除重复的元组
            if (i > 0 && nums[i - 1] == nums[i]) {
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

    /**
     * 仍然是三重循环去枚举符合条件的，不重复的三元组，但是省去了查重的消耗，是对solution1的优化
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
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
                        result.add(Lists.newArrayList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }
}
