package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/17 20:23:31
 */
public class _207_课程表 {
    public static void main(String[] args) {
        _207_课程表 instance = new _207_课程表();
        int[][] relation = {{1, 0}, {0, 1}};
        System.out.println(instance.solution1(2, relation));
    }

    /**
     * 广度优先搜索
     * 拓扑排序
     * (1, 0)表示学习课程1之前，必须先学习课程0
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean solution1(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        // 计算每个节点的入度
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }
        // 将所以入度为0的节点入队，即没有前序依赖的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // 广度优先遍历
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int pointA = queue.poll();
            result.add(pointA);
            // 依次找到当前节点pointA指向的节点，将其入度减一，当pointB入度为0时，加入队列
            for (int i = 0; i < prerequisites.length; i++) {
                int pointB = prerequisites[i][0];
                if (prerequisites[i][1] == pointA) {
                    inDegree[pointB]--;
                    if (inDegree[pointB] == 0) {
                        queue.add(pointB);
                    }
                }
            }
        }
        // 如果result.size() != numCourses，表示存在环，即不是有向无环图，不存在拓扑排序
        return result.size() == numCourses;
    }

    /**
     * 深度优先搜索
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean solution2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
