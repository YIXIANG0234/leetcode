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

    /**
     * 动态规划，f[i][0]表示第i天，不持有股票第最大收益，f[i][1]表示第i天持有股票第收益
     * 1. 考虑最后一天，肯定是不持有股票第收益更大，即f[i][0]>=f[i][1]，因此答案为f[i][0]
     * 2. 考虑f[i][0]的情况，有可能是前一天也不持有，或者今天刚卖，则f[i][0]=max(f[i-1][0],f[i-1][1]+prices[i])
     * 3. 考虑f[i][1]的情况，有可能是前一天就持有的，或者今天刚买的，如果是今天刚买的，则收益为f[i-2][0]-prices[i]
     * 即f[i][1]=max(f[i-1][1],f[i-2][0]-prices[i])
     *
     * @param prices
     * @return
     */
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
