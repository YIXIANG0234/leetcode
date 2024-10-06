package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _046_全排列 {
    public static void main(String[] args) {
        _046_全排列 instance = new _046_全排列();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(instance.solution1(nums));
    }

    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, boolean[] flag, List<List<Integer>> result, List<Integer> list) {
        // 全排列完成
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 判断当前数字是否使用在当前的排列钟
            if (flag[i]) {
                continue;
            }
            list.add(nums[i]);
            flag[i] = true;
            ///  递归下一个位置
            backtrack(nums, flag, result, list);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    /**
     * 交换法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int length = nums.length;
        backtrack2(output, 0, result, length);
        return result;
    }

    private void backtrack2(List<Integer> output, int index, List<List<Integer>> result, int length) {
        if (index == length) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i = index; i < length; i++) {
            Collections.swap(output, index, i);
            backtrack2(output, index + 1, result, length);
            Collections.swap(output, index, i);
        }
    }
}
