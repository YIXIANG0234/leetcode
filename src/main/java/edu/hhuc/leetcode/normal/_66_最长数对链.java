package edu.hhuc.leetcode.normal;

import java.util.Arrays;
import java.util.Comparator;

public class _66_最长数对链 {

    public static void main(String[] args) {
        _66_最长数对链 instance = new _66_最长数对链();
        System.out.println(instance.solution1(new int[][]{{1, 2}, {7, 8}, {4, 5}}));
    }

    /**
     * 动态规划，时间复杂度为O(n^2)
     *
     * @param pairs
     * @return
     */
    public int solution1(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(e -> e[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            int currentMaxLength = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    currentMaxLength = Math.max(currentMaxLength, dp[j] + 1);
                }
            }
            dp[i] = currentMaxLength;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    /**
     * 贪心算法，时间复杂度为O(n)
     *
     * @param pairs
     * @return
     */
    public int solution2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int maxLength = 1;
        int lastPairPositionOne = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastPairPositionOne) {
                lastPairPositionOne = pairs[i][1];
                maxLength++;
            }
        }
        return maxLength;
    }
}
