package edu.hhuc.leetcode.base.sort;

/**
 * 排序算法：快速排序
 * 是否稳定排序：非稳定排序
 * 是否原地排序：非原地排序
 * 最好时间复杂度：O(nlogn)
 * 最坏时间复杂度：O(n^2)
 * 平均时间复杂度：O(nlogn)
 *
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 11:25:53
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        internalQuickSort(arr, 0, arr.length - 1);
    }

    private void internalQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        internalQuickSort(arr, left, pivot - 1);
        internalQuickSort(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= base) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= base) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        return left;
    }
}
