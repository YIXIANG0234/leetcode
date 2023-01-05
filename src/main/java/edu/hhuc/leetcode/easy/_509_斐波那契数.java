package edu.hhuc.leetcode.easy;

public class _509_斐波那契数 {
    public int solution1(int n) {
        if (n <= 1) {
            return n;
        }
        return solution1(n - 1) + solution1(n - 2);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int solution2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * 空间复杂度位O(1)的动态规划
     *
     * @param n
     * @return
     */
    public int solution3(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
