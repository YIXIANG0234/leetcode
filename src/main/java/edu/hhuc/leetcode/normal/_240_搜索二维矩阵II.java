package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/21 21:53:41
 */
public class _240_搜索二维矩阵II {
    public static void main(String[] args) {
        _240_搜索二维矩阵II instance = new _240_搜索二维矩阵II();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 28;
        System.out.println(instance.solution3(matrix, target));
    }

    /**
     * 从左下脚开始查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean solution1(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                System.out.println(i + ":" + j);
                return true;
            }
            if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

    /**
     * 从右上脚开始查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean solution2(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.println(i + ":" + j);
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /**
     * 对每一行进行二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean solution3(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = binarySearch(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
