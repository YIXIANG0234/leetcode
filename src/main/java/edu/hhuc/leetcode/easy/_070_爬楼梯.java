package edu.hhuc.leetcode.easy;

public class _070_爬楼梯 {
    public static void main(String[] args) {
        _070_爬楼梯 instance = new _070_爬楼梯();
        System.out.println(instance.solution1(45));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化空间复杂度的动态规划
     *
     * @param n
     * @return
     */
    public int solution2(int n) {
        if (n <= 2) {
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        for (int i = 3; i <= n; i++) {
            int step = step1 + step2;
            step1 = step2;
            step2 = step;
        }
        return step2;
    }

    /**
     * 递归的解法
     * 但是有重复子问题，相比于solution1，性能不好，会超时
     *
     * @param n
     * @return
     */
    public int solution3(int n) {
        if (n <= 2) {
            return n;
        }
        return solution3(n - 1) + solution3(n - 2);
    }

}
