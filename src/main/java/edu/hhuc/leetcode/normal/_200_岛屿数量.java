package edu.hhuc.leetcode.normal;

import java.util.LinkedList;
import java.util.Queue;

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
     * 依次枚举每个点作为岛屿的起点，如果是1，则进行深度优先搜索，将该岛屿中的其他点变为0
     * 然后遍历下一个岛屿起点
     *
     * @param grid
     * @return
     */
    public int solution1(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
//                    dfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 深度优先搜索
     *
     * @param grid
     * @param rowIndex
     * @param columnIndex
     */
    private void dfs(char[][] grid, int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex >= grid.length || columnIndex < 0 || columnIndex >= grid[0].length || grid[rowIndex][columnIndex] != '1') {
            return;
        }
        grid[rowIndex][columnIndex] = '0';
        dfs(grid, rowIndex - 1, columnIndex);
        dfs(grid, rowIndex + 1, columnIndex);
        dfs(grid, rowIndex, columnIndex - 1);
        dfs(grid, rowIndex, columnIndex + 1);
    }

    /**
     * 广度优先搜索
     *
     * @param grid
     * @param rowIndex
     * @param columnIndex
     */
    private void bfs(char[][] grid, int rowIndex, int columnIndex) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rowIndex, columnIndex});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                queue.add(new int[]{i - 1, j});
                queue.add(new int[]{i, j - 1});
                queue.add(new int[]{i + 1, j});
                queue.add(new int[]{i, j + 1});
            }
        }
    }

}
