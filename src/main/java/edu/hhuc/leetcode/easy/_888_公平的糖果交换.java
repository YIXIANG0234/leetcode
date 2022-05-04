package edu.hhuc.leetcode.easy;

import java.util.Arrays;

public class _888_公平的糖果交换 {
    public static void main(String[] args) {
        _888_公平的糖果交换 instance = new _888_公平的糖果交换();
        int[] a = new int[]{1, 1};
        int[] b = new int[]{2, 2};
        instance.solution1(a, b);
    }

    /**
     * 需要推理出计算公式，设x为alice交换的糖果，y为bob交换的糖果
     * sumA - x + y = sumB - y + x;
     * 得到
     * x = y + (sumA - sumB)/2;
     *
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public int[] solution1(int[] aliceSizes, int[] bobSizes) {
        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();
        int diff = sumA - sumB;
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int i = 0;
        int j = 0;
        while (i < aliceSizes.length && j < bobSizes.length) {
            if (aliceSizes[i] == (bobSizes[j] + diff / 2)) {
                return new int[]{aliceSizes[i], bobSizes[j]};
            } else if (aliceSizes[i] < (bobSizes[j] + diff / 2)) {
                i++;
            } else {
                j++;
            }
        }
        return new int[]{0, 0};
    }
}
