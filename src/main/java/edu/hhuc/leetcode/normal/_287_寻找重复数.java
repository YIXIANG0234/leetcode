package edu.hhuc.leetcode.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/22 16:54:57
 */
public class _287_寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4, 5, 2};
        _287_寻找重复数 instance = new _287_寻找重复数();
        System.out.println(instance.solution2(nums));
    }

    public int solution1(int[] nums) {
        Set<Integer> exists = new HashSet<>();
        for (int num : nums) {
            if (exists.contains(num)) {
                return num;
            }
            exists.add(num);
        }
        return -1;
    }

    public int solution2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int solution3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int v : nums) {
                if (v <= mid) {
                    ++cnt;
                }
            }
            if (cnt > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
