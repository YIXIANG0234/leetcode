package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @ClassName _039_组合总和
 * @description:
 * @author: gaoya
 * @create: 2023-02-23 10:57
 * @Version 1.0
 */
public class _039_组合总和 {
    public static void main(String[] args) {
        _039_组合总和 instance = new _039_组合总和();
        System.out.println(instance.solution2(new int[]{2, 3, 6, 7}, 7));
    }

    /**
     * 回溯的写法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> solution1(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backTrace(combinations, combination, candidates, target, 0);
        return combinations;
    }

    public void backTrace(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (target - candidates[index] >= 0) {
            combination.add(candidates[index]);
            backTrace(combinations, combination, candidates, target - candidates[index], index);
            combination.remove(combination.size() - 1);
        }
        backTrace(combinations, combination, candidates, target, index + 1);
    }


    /**
     * 回溯的第二种写法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> solution2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace2(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void backTrace2(int[] candidates, int target, List<Integer> list, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                backTrace2(candidates, target - candidates[i], list, result, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
