package edu.hhuc.leetcode.easy;

import java.util.*;

public class _594_最长和谐子序列 {
    public static void main(String[] args) {
        _594_最长和谐子序列 instance = new _594_最长和谐子序列();
        System.out.println(instance.solution1(new int[]{2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2, 2, 0, 1, 2, 2, 3, 2}));
    }

    /**
     * 暴力枚举，每次遍历以第一个元素为基准，分别统计基准值+1和基准值减一的序列，找到最长的有效和谐序列
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录比基准值小1的子序列
            List<Integer> list1 = new ArrayList<>();
            // 记录比基准值大1的子序列
            List<Integer> list2 = new ArrayList<>();
            list1.add(nums[i]);
            list2.add(nums[i]);
            // flag1,flag2分别记录两个序列中的元素最大最小值的差值是否为1
            boolean flag1 = false;
            boolean flag2 = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] || nums[j] - 1 == nums[i]) {
                    list1.add(nums[j]);
                    if (nums[j] - 1 == nums[i]) {
                        flag1 = true;
                    }
                }
                if (nums[j] == nums[i] || nums[j] + 1 == nums[i]) {
                    list2.add(nums[j]);
                    if (nums[j] + 1 == nums[i]) {
                        flag2 = true;
                    }
                }
            }
            if (!flag1 && !flag2) {
                continue;
            }
            if (!flag1) {
                maxLength = Math.max(maxLength, list2.size());
            } else if (!flag2) {
                maxLength = Math.max(maxLength, list1.size());
            } else {
                maxLength = Math.max(maxLength, Math.max(list1.size(), list2.size()));
            }
        }
        return maxLength;
    }

    /**
     * 排序算法
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1) {
                maxCount = Math.max(maxCount, right - left + 1);
            }
            right++;
        }
        return maxCount;
    }

    /**
     * hash表
     *
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : nums) {
            if (map.containsKey(num + 1)) {
                maxCount = Math.max(maxCount, map.get(num) + map.get(num + 1));
            }
        }
        return maxCount;
    }

}