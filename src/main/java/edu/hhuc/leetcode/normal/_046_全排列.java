package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _046_全排列 {
    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        _046_全排列 instance = new _046_全排列();
        int[] nums = {1, 2, 3};
        System.out.println(instance.solution2(nums));
    }

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        // 用来标记元素是否被使用
        boolean[] judge = new boolean[nums.length];
        List<Integer> possibility = new ArrayList<>();
        int index = 0;
        permute(nums, possibility, judge, index);
        return result;
    }

    public void permute(int[] nums, List<Integer> possibility, boolean[] judge, int index) {
        // 当前的排序已经枚举结束，加入结果集中
        if (index == nums.length) {
            result.add(new ArrayList<>(possibility));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 该元素使用过，枚举下一个未使用过的元素
            if (judge[i]) {
                continue;
            }
            possibility.add(nums[i]);
            judge[i] = true;
            // 递归查找下一个位置
            permute(nums, possibility, judge, index + 1);
            judge[i] = false;
            possibility.remove(index);
        }
    }

    /**
     * 交换法
     * @param nums
     * @return
     */
    public List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int length = nums.length;
        backtrack(output, 0, result, length);
        return result;
    }

    private void backtrack(List<Integer> output, int index, List<List<Integer>> result, int length) {
        if (index == length) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i=index;i<length;i++) {
            Collections.swap(output, index, i);
            backtrack(output, index+1, result, length);
            Collections.swap(output, index, i);
        }
    }

    public List<List<Integer>> solution3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        test(nums, new int[nums.length], new ArrayList<>(), result);
        return result;
    }

    public void test(int[] nums, int[] valid, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < valid.length; i++) {
            if (valid[i] == -1) {
                continue;
            }
            list.add(nums[i]);
            valid[i] = -1;
            test(nums, valid, list, result);
            valid[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
