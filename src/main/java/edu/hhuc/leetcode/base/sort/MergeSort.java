package edu.hhuc.leetcode.base.sort;

/**
 * 排序算法：归并排序
 * 是否稳定排序：稳定排序
 * 是否原地排序：非原地排序
 * 最好时间复杂度：O(nlogn)
 * 最坏时间复杂度：O(nlogn)
 * 平均时间复杂度：O(nlogn)
 *
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 11:15:06
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        internalMergeSort(arr, 0, arr.length - 1);
    }

    private void internalMergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 不使用：(right + left) / 2，主要是为了防止left和right很多的时候，数据溢出
        int mid = left + (right - left) / 2;
        internalMergeSort(arr, left, mid);
        internalMergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // 新建临时数组，存放两个有序部分合并的结果
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        // 定义两个指针，分别指向两个有序序列开始位置
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                index++;
                i++;
            } else {
                temp[index] = arr[j];
                index++;
                j++;
            }
        }
        // 处理有序序列剩下的元素
        while (i <= mid) {
            temp[index] = arr[i];
            index++;
            i++;
        }
        while (j <= right) {
            temp[index] = arr[j];
            index++;
            j++;
        }
        // 将合并结果写回原数组
        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }
}
