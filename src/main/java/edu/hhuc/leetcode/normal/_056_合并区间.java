package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/12 10:37:54
 */
public class _056_合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        _056_合并区间 instance = new _056_合并区间();
        int[][] result = instance.solution1(intervals);
        ConsoleFormatter.arrayToConsole(result);
    }

    public int[][] solution1(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            boolean merged = false;
            for (List<Integer> list : result) {
                if (list.get(1) >= intervals[i][0] && list.get(0) <= intervals[i][1]) {
                    list.set(0, Math.min(list.get(0), intervals[i][0]));
                    list.set(1, Math.max(list.get(1), intervals[i][1]));
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                result.add(Arrays.stream(intervals[i]).boxed().collect(Collectors.toList()));
            }
        }
        return convert(result);
    }

    private int[][] convert(List<List<Integer>> result) {
        int len = result.size();
        int[][] array = new int[len][2];
        for (int i = 0; i < len; i++) {
            array[i][0] = result.get(i).get(0);
            array[i][1] = result.get(i).get(1);
        }
        return array;
    }
}
