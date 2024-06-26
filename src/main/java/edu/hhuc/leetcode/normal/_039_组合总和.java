package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
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
        System.out.println(instance.solution1(new int[]{2, 3, 5, 8}, 8));
    }

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
}
