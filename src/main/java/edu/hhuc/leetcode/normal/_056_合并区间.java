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
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
//        int[][] intervals = {
//                {2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}
//        };
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
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            // 只需要和最后一个区间比较就行了
            int[] tail = result.get(result.size() - 1);
            // 并入最后一个区间
            if (intervals[i][0] <= tail[1]) {
                tail[1] = Math.max(intervals[i][1], tail[1]);
            } else {
                // 新开一个区间
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return result.toArray(new int[][]{});
    }
}
