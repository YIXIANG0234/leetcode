package edu.hhuc.leetcode.others;

import java.util.Scanner;

public class HJ024_合唱队 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[j] + 1, left[i]);
                }
            }
        }

        right[n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[j] + 1, right[i]);
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] + right[i] - 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(result[i], max);
        }
        System.out.println(n - max);
    }
}
