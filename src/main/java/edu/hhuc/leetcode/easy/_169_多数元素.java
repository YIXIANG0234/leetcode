package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169_多数元素 {

    public static void main(String[] args) {
        _169_多数元素 instance = new _169_多数元素();
        System.out.println(instance.solution5(new int[]{7, 3, 3, 5, 3, 4, 3}));
    }

    /**
     * hash表统计
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Map.Entry<Integer, Integer> majority = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majority == null) {
                majority = entry;
            }
            if (entry.getValue() > majority.getValue()) {
                majority = entry;
            }
        }
        return majority.getKey();
    }

    /**
     * 多数元素是指在数组中出现次数大于[n/2]的元素
     * 将数组排序后，取中间的一个元素即可
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[(int) Math.ceil(nums.length / 2)];
    }

    /**
     * 投票法
     *
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count = count + (candidate == num ? 1 : -1);
        }
        return candidate;
    }

    public int solution4(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[1];
        map.forEach((k, v) -> {
            if (v > nums.length / 2) {
                result[0] = k;
            }
        });
        return result[0];
    }

    public int solution5(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len/2];
    }
}
