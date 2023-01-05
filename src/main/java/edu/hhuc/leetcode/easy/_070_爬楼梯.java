package edu.hhuc.leetcode.easy;

public class _070_爬楼梯 {
    /**
     * 上第n个台阶的方法数等于上第n-1个台阶和上第n-2个台阶的方法数之和
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        // 前两级楼梯的方法数分别为1和2
        if (n <= 2) {
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        int step = 0;
        for (int i = 3; i <= n; i++) {
            step = step1 + step2;
            step1 = step2;
            step2 = step;
        }
        return step;
    }

    /**
     * 递归的解法
     * 但是有重复子问题，相比于solution1，性能不好，会超时
     * @param n
     * @return
     */
    public int solution2(int n) {
        if (n <= 2) {
            return n;
        }
        return solution2(n - 1) + solution2(n - 2);
    }
}
