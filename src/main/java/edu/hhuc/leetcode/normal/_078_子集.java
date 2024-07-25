package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/12 17:23:32
 */
public class _078_子集 {
    public static void main(String[] args) {
        _078_子集 instance = new _078_子集();
        int[] nums = {1, 2, 3};
        System.out.println(instance.solution1(nums));
    }

    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrace(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void backtrace(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            backtrace(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
