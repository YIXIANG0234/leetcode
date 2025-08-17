package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/11 16:28:19
 */
public class _048_旋转图像 {
    public static void main(String[] args) {
        _048_旋转图像 instance = new _048_旋转图像();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        instance.solution1(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 借助额外的辅助数组
     *
     * @param matrix
     */
    public void solution1(int[][] matrix) {
        int n = matrix.length;
        int[][] transform = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transform[j][n - i - 1] = matrix[i][j];
            }
        }
        // 复制到原数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = transform[i][j];
            }
        }
    }

    /**
     * 水平翻转 + 左上-右下的对角线翻转
     *
     * @param matrix
     */
    public void solution2(int[][] matrix) {
        int n = matrix.length;
        // 先水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 然后沿左上-右下的对角线翻转
        for (int i = 0; i < n; i++) {
            // 很重要，这里是j<i, 而不是j<n，如果j<n的话就又翻转回去了
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 旋转
     *
     * @param matrix
     */
    public void solution3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
