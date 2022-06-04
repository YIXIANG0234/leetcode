package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _047_全排列II {
    public static void main(String[] args) {
        _047_全排列II instance = new _047_全排列II();
        int[] nums = {1, 2, 1};
        System.out.println(instance.solution1(nums));
    }

    /**
     * 与46题类似
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(0, nums.length, result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrace(int index, int length, List<List<Integer>> result, List<Integer> possibility, int[] nums, boolean[] judge) {
        if (index == length) {
            result.add(new ArrayList<>(possibility));
            return;
        }
        // 额外使用一个set来记录，当前位置已经使用过的元素
        Set<Integer> hasChoose = new HashSet<>();
        for (int i = 0; i < length; i++) {
            // 如果当前位置已经使用过该元素了，则不再进行枚举
            if (judge[i] || hasChoose.contains(nums[i])) {
                continue;
            }
            possibility.add(nums[i]);
            hasChoose.add(nums[i]);
            judge[i] = true;
            backtrace(index + 1, length, result, possibility, nums, judge);
            judge[i] = false;
            possibility.remove(index);
        }
    }
}
