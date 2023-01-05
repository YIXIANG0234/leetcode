package edu.hhuc.leetcode.normal;

public class _343_整数拆分 {
    public static void main(String[] args) {
        _343_整数拆分 instance = new _343_整数拆分();
        System.out.println(instance.solution1(10));
    }

    /**
     * 动态规划，dp[i]代表数字i拆分时得到的乘积最大值
     * 将i拆分为a+b，其中a从1枚举到i,即1<=a<=i,
     * 则dp[i]=max(a*b,a*dp[b])
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int currentMax = 0;
            for (int j = 1; j < i; j++) {
                currentMax = Math.max(currentMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = currentMax;
        }
        return dp[n];
    }
}
