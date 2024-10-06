package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/12 10:37:54
 */
public class _056_合并区间 {
    public static void main(String[] args) {
//        int[][] intervals = {
//                {1, 3}, {2, 6}, {8, 10}, {15, 18}
//        };
        int[][] intervals = {
                {2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}
        };
        _056_合并区间 instance = new _056_合并区间();
        int[][] result = instance.solution1(intervals);
        ConsoleFormatter.arrayToConsole(result);
    }

    /**
     * 排序
     *
     * @param intervals
     * @return
     */
    public int[][] solution1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> merged = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }

}
