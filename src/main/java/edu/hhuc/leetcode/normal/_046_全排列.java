package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _046_全排列 {
    public static void main(String[] args) {
        _046_全排列 instance = new _046_全排列();
        int[] nums = {1, 2, 3};
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
        backtrace(nums, new ArrayList<>(), result, new int[nums.length]);
        return result;
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
        backtrace(output, 0, result);
        return result;
    }

    /**
     * index表示该外置是待插入数字的位置，[0,index-1]是已经使用过的数字
     * [index,output.length-1]是还未使用的数字，使用交换法进行求解
     *
     * @param output
     * @param index
     * @param result
     */
    private void backtrace(List<Integer> output, int index, List<List<Integer>> result) {
        if (index == output.size()) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i = index; i < output.size(); i++) {
            Collections.swap(output, index, i);
            backtrace(output, index + 1, result);
            Collections.swap(output, index, i);
        }
    }

    private void backtrace(int[] nums, List<Integer> list, List<List<Integer>> result, int[] selected) {
        // 得到一个完整的排列
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已经在本轮选择过了，则跳过
            if (selected[i] == 1) {
                continue;
            }
            selected[i] = 1;
            list.add(nums[i]);
            backtrace(nums, list, result, selected);
            list.remove(list.size() - 1);
            selected[i] = 0;
        }
    }
}
