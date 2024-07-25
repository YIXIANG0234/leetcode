package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/22 20:35:17
 */
public class _309_买卖股票的最佳时机含冷冻期 {
    public static void main(String[] args) {
        _309_买卖股票的最佳时机含冷冻期 instance = new _309_买卖股票的最佳时机含冷冻期();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(instance.solution1(prices));
    }

    public int solution1(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
            f[i][1] = Math.max(f[i - 1][1], (i > 1 ? f[i - 2][0] : 0) - prices[i]);
        }
        return f[n - 1][0];
    }
}
