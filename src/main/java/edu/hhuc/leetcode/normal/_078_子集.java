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

    /**
     * 回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrace(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrace(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            // 子集中下一个元素的位置从i+1开始
            backtrace(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 回溯的另一种写法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace2(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrace2(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 当前位置的元素不加入子集
        backtrace2(nums, index + 1, result, list);

        // 当前位置的元素加入子集
        list.add(nums[index]);
        backtrace2(nums, index + 1, result, list);
    }

    /**
     * 迭代法，在结果集中，不断选出子集，然后构造新的子集，并加入结果集中
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 回溯的另一种写法，感觉更好理解一点
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        // 枚举当前元素个数为i的组合
        for (int i = 1; i <= nums.length; i++) {
            // 计算个数为i的组合
            backtrace3(nums, 0, result, i, new ArrayList<>());
        }
        return result;
    }

    private void backtrace3(int[] nums, int index, List<List<Integer>> result, int n, List<Integer> list) {
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace3(nums, i + 1, result, n, list);
            list.remove(list.size() - 1);
        }
    }
}
