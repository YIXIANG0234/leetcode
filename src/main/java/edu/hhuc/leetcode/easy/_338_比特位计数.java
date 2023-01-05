package edu.hhuc.leetcode.easy;

import java.util.Arrays;

public class _338_比特位计数 {
    public static void main(String[] args) {
        _338_比特位计数 instance = new _338_比特位计数();
        System.out.println(Arrays.toString(instance.solution1(5)));
    }

    /**
     * 逐位判断
     * @param n
     * @return
     */
    public int[] solution1(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = bitCount(i);
            // 或者使用内置的函数计算
            // result[i] = Integer.bitCount(i);
        }
        return result;
    }

    private int bitCount(int num) {
        int count = 0;
        while (num != 0) {
            count = count + (num & 1);
            num = num >> 1;
        }
        return count;
    }
}
