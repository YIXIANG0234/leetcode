package edu.hhuc.leetcode.easy;

import java.util.Arrays;

public class _455_分发饼干 {
    public int solution1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index1 = 0;
        int index2 = 0;
        while (index1 < g.length && index2 < s.length) {
            if (s[index2] >= g[index1]) {
                // 已找到满足孩子尺寸的饼干，并为下一个孩子寻找满足尺寸的饼干
                index1++;
                index2++;
            } else {
                // 寻找可以满足孩子尺寸的饼干
                index2++;
            }
        }
        // index1的值即为满足孩子的个数
        return index1;
    }
}
