package edu.hhuc.leetcode.base.sort;

/**
 * 排序算法：冒泡排序
 * 是否稳定排序：稳定排序
 * 是否原地排序：原地排序
 * 最好时间复杂度：O(n)
 * 最坏时间复杂度：O(n^2)
 * 平均时间复杂度：O(n^2)
 *
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 10:21:12
 */
public class BubbleSorter implements Sort {
    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
            // 数组已经有序了
            if (sorted) {
                break;
            }
        }
    }
}
