package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/19 17:26:40
 */
public class _221_最大正方形 {
    public static void main(String[] args) {
        _221_最大正方形 instance = new _221_最大正方形();
        char[][] matrix = {
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };
        System.out.println(instance.solution2(matrix));
    }

    /**
     * 动态规划
     * 定义dp[i][j]为以(i,j)坐标作为正方形的右下角的最大正方形边长
     *
     * @param matrix
     * @return
     */
    public int solution1(char[][] matrix) {
        int maxSide = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 暴力解法，会超时
     *
     * @param matrix
     * @return
     */
    public int solution2(char[][] matrix) {
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 如果当前位置是1，则以当前位置作为正方形的左上角，计算可能的最大正方形面积
                if (matrix[i][j] == '1') {
                    maxArea = Math.max(maxArea, calculateArea(matrix, i, j));
                }
            }
        }
        return maxArea;
    }

    private int calculateArea(char[][] matrix, int row, int col) {
        int area = 1;
        int bound = Math.min(matrix.length - row, matrix[row].length - col);
        // bound为可以增加的边长，从1开始增加正方形边长
        for (int k = 1; k < bound; k++) {
            // 后面的两重循环，判断是否是正方形
            for (int i = row; i <= row + k; i++) {
                for (int j = col; j <= col + k; j++) {
                    if (matrix[i][j] == '0') {
                        return area;
                    }
                }
            }
            area = (k + 1) * (k + 1);
        }
        return area;
    }


}
