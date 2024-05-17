package edu.hhuc.leetcode.base.sort;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 20:55:51
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int delta = arr.length / 2; delta >= 1; delta /= 2) {
            for (int i = 0; i < arr.length; i += delta) {
                for (int j = i; j > 0; j -= delta) {
                    if (arr[j] < arr[j - delta]) {
                        int temp = arr[j];
                        arr[j] = arr[j - delta];
                        arr[j - delta] = temp;
                    }
                }
            }
        }
    }
}
