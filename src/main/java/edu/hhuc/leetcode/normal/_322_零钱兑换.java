package edu.hhuc.leetcode.normal;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/22 21:58:26
 */
public class _322_零钱兑换 {
    public static void main(String[] args) {
        _322_零钱兑换 instance = new _322_零钱兑换();
        int[] coins = {2, 5};
        int amount = 3;
        System.out.println(instance.solution1(coins, amount));
    }

    public int solution1(int[] coins, int amount) {
        int count = 0;
        Arrays.sort(coins);
        while (amount > 0) {
            int i = coins.length - 1;
            for (; i >= 0; i--) {
                if (coins[i] <= amount) {
                    amount = amount - coins[i];
                    count++;
                    break;
                }
            }
            if (i < 0) {
                return -1;
            }
        }
        return count;
    }
}
