package edu.hhuc.leetcode.easy;

import java.util.LinkedList;

/**
 * 相关的问题类型，leetcode搜索关键字：股票
 */
public class _121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        _121_买卖股票的最佳时机 instance = new _121_买卖股票的最佳时机();
        int[] prices = {7, 1, 5, 3, 6, 4};
        // int[] prices = {7, 6, 4, 3, 1};
        System.out.println(instance.solution5(prices));
    }

    /**
     * 这一题，只能选择一天买入，只能选择一天卖出，也就是只有两天可以操作
     * 暴力枚举，求出最大利润，会超时
     *
     * @param prices
     * @return
     */
    public int solution1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                int profit = sell - buy;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历
     *
     * @param prices
     * @return
     */
    public int solution2(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    /**
     * 单调递增栈
     *
     * @param prices
     * @return
     */
    public int solution3(int[] prices) {
        LinkedList<Integer> stack = new LinkedList<>();
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peekFirst() > prices[i]) {
                int current = stack.peekFirst() - stack.peekLast();
                stack.pollFirst();
                maxProfit = Math.max(maxProfit, current);
            }
            stack.addFirst(prices[i]);
        }
        // 如果到了最后一天，栈还未清空，则计算栈顶和栈底元素的差值
        if (!stack.isEmpty()) {
            maxProfit = Math.max(maxProfit, stack.peekFirst() - stack.peekLast());
        }
        return maxProfit;
    }

    public int solution4(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int solution5(int[] prices) {
        int max = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[index]) {
                index = i;
                continue;
            }
            max = Math.max(max, prices[i] - prices[index]);
        }
        return max;
    }
}
