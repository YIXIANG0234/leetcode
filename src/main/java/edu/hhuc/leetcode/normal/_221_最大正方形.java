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
        System.out.println(instance.solution1(matrix));
    }

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

    public int backtrace(char[][] matrix, int i, int j, int nextI, int nextJ) {
        int maxArea = (nextI - i + 1) * (nextJ - j + 1);
        for (; i < nextI; i++) {
            for (; j < nextJ; j++) {
                if (matrix[i][j] == '0') {
                    return maxArea;
                }
            }
        }
        maxArea = (nextI - i + 1) * (nextJ - j + 1);
        return maxArea;
    }
}
