package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/14 17:28:20
 */
public class _096_不同的二叉搜索树 {
    public static void main(String[] args) {
        _096_不同的二叉搜索树 instance = new _096_不同的二叉搜索树();
        System.out.println(instance.solution1(3));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int solution1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j - 1] + dp[i - j];
            }
        }
        return dp[n];
    }

}
