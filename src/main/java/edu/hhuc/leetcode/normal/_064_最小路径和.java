package edu.hhuc.leetcode.normal;

public class _064_最小路径和 {
    public static void main(String[] args) {
        _064_最小路径和 instance = new _064_最小路径和();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        System.out.println(instance.solution2(grid));
        System.out.println(findK(grid, 5));

        int[][] grid2 = {{1,2,3},{4,5,6}};
        System.out.println(findK(grid2, 6));
    }

    public int solution1(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            if (i == 0) {
                dp[i][0] = grid[0][0];
                continue;
            }
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 0; i < colLength; i++) {
            if (i == 0) {
                dp[0][i] = grid[0][i];
                continue;
            }
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rowLength - 1][colLength - 1];
    }

    /**
     * 滚动数组优化空间复杂度，每次只记录当前行的数据
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

    public static int findK(int[][] arr, int k) {
        int rowLength = arr.length;
        int colLength = arr[0].length;
        int[][] dp = new int[rowLength][colLength];

        // 第1个节点的路径和，等于该节点的值
        dp[0][0] = arr[0][0];

        // 计算第一行，每个节点的路径和
        for(int i=1;i<colLength;i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        // 计算第一列，每个节点的路径和
        for(int j=1;j< rowLength;j++) {
            dp[j][0] = dp[j-1][0]+arr[j][0];
        }

        // 遍历arr,计算第k个节点的路径和
        for (int i=1;i<rowLength;i++) {
            for(int j=1;j<colLength;j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }
        int index = 1;
        int result = 0;
        // 遍历结果集，得到第k个节点的路径和
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++) {
                if (index == k) {
                    result = dp[i][j];
                    break;
                }
                index++;
            }
        }
        return result;
    }

}
