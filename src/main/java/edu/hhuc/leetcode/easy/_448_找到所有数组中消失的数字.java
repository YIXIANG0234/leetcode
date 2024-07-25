package edu.hhuc.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/23 16:55:17
 */
public class _448_找到所有数组中消失的数字 {

    public static void main(String[] args) {
        _448_找到所有数组中消失的数字 instance = new _448_找到所有数组中消失的数字();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(instance.solution3(nums));
    }

    public List<Integer> solution1(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> solution2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            int j = 0;
            while (j < nums.length) {
                if (nums[j] == i) {
                    break;
                }
                j++;
            }
            if (j == nums.length) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> solution3(int[] nums) {
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
            }
        }
        return result;
    }
}
