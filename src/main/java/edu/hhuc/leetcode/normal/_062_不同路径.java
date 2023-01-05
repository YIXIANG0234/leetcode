package edu.hhuc.leetcode.normal;

public class _062_不同路径 {
    public static void main(String[] args) {
        _062_不同路径 instance = new _062_不同路径();
        System.out.println(instance.solution1(7, 3));
    }

    /**
     * 动态规划，dp[i][j]表示到底（i,j)的方法数，dp[i][j]=dp[i-1][j]+dp[i][j-1]
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
}
