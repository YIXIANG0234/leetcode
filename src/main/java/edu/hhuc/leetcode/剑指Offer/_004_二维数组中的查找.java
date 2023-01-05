package edu.hhuc.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class _004_二维数组中的查找 {
    public static void main(String[] args) {
        _004_二维数组中的查找 instance = new _004_二维数组中的查找();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(instance.solution2(matrix, 21));
    }

    public boolean solution1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    for (int k = i; k < matrix.length && j > 0; k++) {
                        if (matrix[k][j - 1] == target) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean solution2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
