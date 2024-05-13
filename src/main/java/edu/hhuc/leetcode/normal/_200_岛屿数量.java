package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _200_岛屿数量
 * @description:
 * @author: gaoya
 * @create: 2023-03-07 18:19
 * @Version 1.0
 */
public class _200_岛屿数量 {
    /**
     * 深度优先搜索算法
     *
     * @param grid
     * @return
     */
    public int solution1(char[][] grid) {
        int quantity = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    quantity++;
                    dfs(grid, i, j);
                }
            }
        }
        return quantity;
    }

    public void dfs(char[][] grid, int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex >= grid.length || columnIndex < 0 || columnIndex >= grid[0].length || grid[rowIndex][columnIndex] == '0') {
            return;
        }
        grid[rowIndex][columnIndex] = '0';
        dfs(grid, rowIndex - 1, columnIndex);
        dfs(grid, rowIndex + 1, columnIndex);
        dfs(grid, rowIndex, columnIndex - 1);
        dfs(grid, rowIndex, columnIndex + 1);
    }
}
