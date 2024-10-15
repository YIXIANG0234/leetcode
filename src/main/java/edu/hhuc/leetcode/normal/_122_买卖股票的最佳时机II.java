package edu.hhuc.leetcode.normal;

import java.util.Stack;

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
        for (int i = 0; i < prices.length - 1; i++) {
            amount += Math.max(0, prices[i + 1] - prices[i]);
        }
        return amount;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int solution2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[i][0]：不持有股票的时候的最大利润
        // dp[i][1]：持有股票的时候的最大利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划空间优化版本
     *
     * @param prices
     * @return
     */
    public int solution3(int[] prices) {
        int len = prices.length;
        int hold = -prices[0];
        int noHole = 0;
        for (int i = 1; i < len; i++) {
            int a = Math.max(noHole, hold + prices[i]);
            int b = Math.max(hold, noHole - prices[i]);
            noHole = a;
            hold = b;
        }
        return noHole;
    }

    /**
     * 单调栈
     *
     * @param prices
     * @return
     */
    public int solution4(int[] prices) {
        int maxProfit = 0;
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        int first = 0;
        for (int i = 0; i < prices.length; i++) {
            // 当某天的价格小于栈顶元素时，将栈出空，目的是为了拿到栈顶和栈底的差值计算利润，即整个交易的最大利润等于多个单调栈的利润之和
            if (!stack.isEmpty() && prices[i] < stack.peek()) {
                first = stack.peek();
                while (!stack.isEmpty()) {
                    first = stack.pop();
                }
                maxProfit = maxProfit + (last - first);
            }
            stack.push(prices[i]);
            last = prices[i];
        }
        // 如果栈未空的话，处理最后一次交易

        while (!stack.isEmpty()) {
            first = stack.pop();
        }
        maxProfit += last - first;
        return maxProfit;
    }
}
