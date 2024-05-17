package edu.hhuc.leetcode.base.sort;

/**
 * 排序算法：选择排序
 * 是否稳定排序：非稳定排序
 * 是否原地排序：原地排序
 * 最好时间复杂度：O(n^2)
 * 最坏时间复杂度：O(n^2)
 * 平均时间复杂度：O(n^2)
 *
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 11:10:27
 */
public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
