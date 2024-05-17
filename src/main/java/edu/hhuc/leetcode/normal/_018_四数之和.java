package edu.hhuc.leetcode.normal;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018_四数之和 {
    public static void main(String[] args) {
        _018_四数之和 instance = new _018_四数之和();
        int[] nums = {0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> result = instance.solution1(nums, 1000000000);
        System.out.println(result);
    }

    public List<List<Integer>> solution1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 剪支，向上转型为long，避免整型溢出问题
            long sum = (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (sum > target) {
                break;
            }
            // 剪支
            sum = (long)nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1];
            if (sum < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                // 剪支
                sum = (long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (sum > target) {
                    break;
                }
                // 剪支
                sum = (long)nums[i] + nums[j] + nums[length - 2] + nums[length - 1];
                if (sum < target) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int total = nums[i] + nums[j] + nums[left] + nums[right];
                    if (total > target) {
                        right--;
                    } else if (total < target) {
                        left++;

                    } else {
                        result.add(Lists.newArrayList(nums[i], nums[j], nums[left], nums[right]));
                        // 去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }

                }
            }
        }
        return result;
    }
}