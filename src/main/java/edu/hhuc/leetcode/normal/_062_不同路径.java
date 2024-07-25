package edu.hhuc.leetcode.normal;

import java.util.concurrent.atomic.AtomicInteger;

public class _062_不同路径 {
    public static void main(String[] args) {
        _062_不同路径 instance = new _062_不同路径();
        System.out.println(instance.solution3(4, 6));
    }

    /**
     * 动态规划，dp[i][j]表示到点（i,j)的方法数，dp[i][j]=dp[i-1][j]+dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public int solution1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < 1 || j < 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int solution2(int m, int n) {
        AtomicInteger count = new AtomicInteger(0);
        backtrace(m, n, 0, 0, count);
        return count.get();
    }

    private void backtrace(int m, int n, int i, int j, AtomicInteger count) {
        if (i == m - 1 && j == n - 1) {
            count.incrementAndGet();
        }
        if (i < m - 1) {
            backtrace(m, n, i + 1, j, count);
        }
        if (j < n - 1) {
            backtrace(m, n, i, j + 1, count);
        }
    }

    public int solution3(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
