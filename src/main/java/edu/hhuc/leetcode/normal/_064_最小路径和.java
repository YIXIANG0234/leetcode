package edu.hhuc.leetcode.normal;

public class _064_最小路径和 {
    public static void main(String[] args) {
        _064_最小路径和 instance = new _064_最小路径和();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(instance.solution1(grid));
    }

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public int solution1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 滚动数组优化空间复杂度，每次只记录当前行的数据
     *
     * @param grid
     * @return
     */
    public int solution2(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] dp = new int[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i == 0) {
                    dp[j] = j > 0 ? dp[j - 1] + grid[i][j] : grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[colLength - 1];
    }


    /**
     * 会超时
     *
     * @param grid
     * @return
     */
    public int solution3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return backtrace(grid, m, n, 0, 0, 0);
    }

    private int backtrace(int[][] grid, int m, int n, int i, int j, int sum) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] + sum;
        }
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        sum = sum + grid[i][j];
        return Math.min(backtrace(grid, m, n, i + 1, j, sum), backtrace(grid, m, n, i, j + 1, sum));
    }


}
