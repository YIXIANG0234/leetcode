package edu.hhuc.leetcode.easy;

import java.util.HashMap;

public class _001_两数之和 {
    /**
     * 暴力枚举
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 借助hash表，实现一次遍历即可找出答案
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 判断遍历过的元素中，是否有和当前元素匹配的
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            // 存储遍历过的元素
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
