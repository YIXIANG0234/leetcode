package edu.hhuc.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _118_杨辉三角 {
    public static void main(String[] args) {
        _118_杨辉三角 instance = new _118_杨辉三角();
//        System.out.println(instance.solution1(5));

        instance.printTriangle(instance.solution1(7));
    }

    public List<List<Integer>> solution1(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                int num = 1;
                if (j != 0 && i != 0 && i != j) {
                    num = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                }
                row.add(num);
            }
            result.add(row);
        }
        return result;
    }

    public void printTriangle(List<List<Integer>> nums) {
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            String s = row.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(s);
        }
    }
}
