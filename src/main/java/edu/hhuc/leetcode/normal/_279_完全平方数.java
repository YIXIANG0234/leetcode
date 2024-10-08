package edu.hhuc.leetcode.normal;

public class _279_完全平方数 {
    public static void main(String[] args) {
        _279_完全平方数 instance = new _279_完全平方数();
        System.out.println(instance.solution1(12));
    }

    public int solution1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                count = Math.min(count, dp[i - j * j]);
            }
            dp[i] = count + 1;
        }
        return dp[n];
    }
}
