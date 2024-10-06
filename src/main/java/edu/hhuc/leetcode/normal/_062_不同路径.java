package edu.hhuc.leetcode.normal;

public class _062_不同路径 {
    public static void main(String[] args) {
        _062_不同路径 instance = new _062_不同路径();
        System.out.println(instance.solution1(19, 13));
    }

    /**
     * 动态规划，dp[i][j]表示到底（i,j)的方法数，dp[i][j]=dp[i-1][j]+dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public int solution1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 回溯解法，会超时
     *
     * @param m
     * @param n
     * @return
     */
    public int solution2(int m, int n) {
        return backtrace(m, n, 0, 0);
    }

    /**
     * (i,j)表示当前坐标
     *
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    private int backtrace(int m, int n, int i, int j) {
        // 已经到达目标点
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        // 该条路径不通
        if (i >= m || j >= n) {
            return 0;
        }
        return backtrace(m, n, i + 1, j) + backtrace(m, n, i, j + 1);
    }

}
