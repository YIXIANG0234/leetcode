package edu.hhuc.leetcode.normal;

public class _122_买卖股票的最佳时机II {
    public static void main(String[] args) {
        _122_买卖股票的最佳时机II instance = new _122_买卖股票的最佳时机II();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(instance.solution1(prices));
    }

    /**
     * 贪心算法，如果后一天的价格比前一天高，则选择前一天买入，后一天卖出
     *
     * @param prices
     * @return
     */
    public int solution1(int[] prices) {
        int amount = 0;
        // -1表示没有持股
        int current = -1;
        for (int i = 0; i < prices.length; i++) {
            if (current != -1 && prices[i] > current) {
                amount += prices[i] - current;
                current = -1;
                System.out.println(String.format("第%d天卖出，售价为：%d，截至目前利润为：%d", i + 1, prices[i], amount));
            }
            if (i != prices.length - 1 && prices[i] <= prices[i + 1]) {
                current = prices[i];
                System.out.println(String.format("第%d天买入，价格为：%d", i + 1, prices[i]));
            }
        }
        return amount;
    }

    /**
     * 贪心算法简洁的表达方式，比solution1简洁
     *
     * @param prices
     * @return
     */
    public int solution2(int[] prices) {
        int amount = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            amount += Math.max(0, prices[i + 1] - prices[i]);
        }
        return amount;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int solution3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
