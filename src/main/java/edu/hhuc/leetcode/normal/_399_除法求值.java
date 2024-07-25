package edu.hhuc.leetcode.normal;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/23 14:26:48
 */
public class _399_除法求值 {

    public static void main(String[] args) {
        _399_除法求值 instance = new _399_除法求值();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Lists.newArrayList("a", "b"));
        equations.add(Lists.newArrayList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Lists.newArrayList("a", "c"));
        queries.add(Lists.newArrayList("b", "a"));
        queries.add(Lists.newArrayList("a", "e"));
        queries.add(Lists.newArrayList("a", "a"));
        queries.add(Lists.newArrayList("x", "x"));
        System.out.println(Arrays.toString(instance.solution1(equations, values, queries)));
    }

    public double[] solution1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }
}
