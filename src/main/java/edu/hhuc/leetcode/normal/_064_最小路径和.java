package edu.hhuc.leetcode.normal;

public class _064_最小路径和 {
    public static void main(String[] args) {
        _064_最小路径和 instance = new _064_最小路径和();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(instance.solution2(grid));
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
        dp[0] = grid[0][0];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i == 0 && j > 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                }
                if (j == 0 && i > 0) {
                    dp[j] = dp[j] + grid[i][j];
                }
                if (i > 0 && j > 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[colLength - 1];
    }
}
