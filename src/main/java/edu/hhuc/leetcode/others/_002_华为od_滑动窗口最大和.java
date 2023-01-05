package edu.hhuc.leetcode.others;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目描述：
 * 有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，
 * 每次窗口滑动产生一个窗口和（窗口内所有数和和），求窗口滑动产生的所有窗口和的最大值。
 * <p>
 * 输入描述：
 * 第一行输入一个正整数N，表示整数个数。（0<N<100000）
 * 第二行输入N个整数，整数的取值范围为[-100,100]。
 * 第三行输入一个正整数M，M代表窗口大小，M<=100000，且M<=N。
 */
public class _002_华为od_滑动窗口最大和 {
    public static void main(String[] args) {
        _002_华为od_滑动窗口最大和 instance = new _002_华为od_滑动窗口最大和();
        int n = 10;
        int m = 5;
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(-100, 100);
        }
//        nums = new int[]{72, -46, 54, -4, -18, -56, 30, -74, -44, -66};
        System.out.println("整数数组nums：");
        System.out.println(Arrays.toString(nums));
        System.out.println(instance.solution1(n, nums, m));
    }

    /**
     * 暴力解法
     *
     * @param n
     * @param nums
     * @param m
     * @return
     */
    public int solution1(int n, int[] nums, int m) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= n - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += nums[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}
