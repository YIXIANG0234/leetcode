package edu.hhuc.leetcode.normal;

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
        int[][] relation = {{1, 0}};
        System.out.println(instance.solution1(2, relation));
    }

    public boolean solution1(int courseNum, int[][] relation) {
        for (int i = 0; i < courseNum; i++) {
            boolean[] flag = new boolean[relation.length];
            int course = i;
            while (true) {

            }
        }
        return true;
    }
}
