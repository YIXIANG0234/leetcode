package edu.hhuc.leetcode.base.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 10:20:00
 */
public interface Sort {
    void sort(int[] arr);

    static boolean sorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static int[] randomArray(int length, int bound) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    static boolean validateArray(int[] origin, int[] arr) {
        int[] copy1 = Arrays.copyOf(origin, origin.length);
        int[] copy2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy1);
        Arrays.sort(copy2);
        return Arrays.toString(copy1).equals(Arrays.toString(copy2));
    }
}
