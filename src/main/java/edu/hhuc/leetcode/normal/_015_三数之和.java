package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _015_三数之和 {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        _015_三数之和 instance = new _015_三数之和();
        System.out.println(instance.solution2(nums));
    }

    /**
     * 暴力枚举，性能有问题
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    if (a + b + c == 0) {
                        List list = Arrays.asList(a, b, c);
                        Collections.sort(list);
                        boolean[] flag = {false};
                        result.stream().forEach(x -> {
                            if (x.equals(list)) {
                                flag[0] = true;
                                return;
                            }
                        });
                        if (!flag[0]) {
                            List item = Arrays.asList(a, b, c);
                            Collections.sort(item);
                            result.add(item);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 先排序，然后使用两个指针查找
     * @param nums
     * @return
     */
    public List<List<Integer>> solution2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 去除重复的元组
            if (i > 0 && nums[i-1] == nums[i]) {
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
